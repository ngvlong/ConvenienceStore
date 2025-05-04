/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI.EmployeeGUI;

import DLL.EmployeeDLL;
import com.formdev.flatlaf.ui.FlatLineBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.TransferHandler;
import javax.swing.border.LineBorder;
import sharedComponents.CheckBox;
import sharedComponents.DateChooser;
import sharedComponents.TextField;

/**
 *
 * @author NAME
 */
public class EmployeeManagement extends JPanel implements MouseListener{
    EmployeeUI nhanvienui;
    JPanel timepanel,pnlgoback,pnladdemployee,pnlemployee_info,pnladdemployee_footer,pnlstore_info;
    JLabel goback,imageLabel;
    TextField tfstore_id,tfstore_phonenumber,tfstore_address,tfstore_area;
    TextField tfemployee_name,tfemployee_id,tfemployee_phonenumber,tfemployee_address,tfemployee_email;
    CheckBox cbemployee_gender;
    DateChooser dcemployee_birthday;
    JTextField employee_image;
    Color btn_color = new Color(0,102,204);
    Color btn_color_hover = new Color(0,76,153);
    Font font = new Font("Roboto",Font.CENTER_BASELINE,20);
    Boolean editable;
    JButton btncancel,btnapply;
    public void initcomponent(EmployeeUI nvui,Boolean edtable) throws IOException{
        this.setLayout(new BorderLayout(10,0));
        nhanvienui = nvui;
        editable = edtable;
        timepanel = eastpanel();
        pnladdemployee = addnhanvienpanel();
        this.add(timepanel,BorderLayout.EAST);
        this.add(pnladdemployee,BorderLayout.CENTER);
        
    }
    
    public JPanel store_infopanel(){
        JPanel panel = new JPanel(null);
        panel.setPreferredSize(new Dimension(0,150));
        panel.setBorder(new FlatLineBorder(new Insets(10,10,10,10), null,0,40));
        panel.setBackground(Color.white);
        
        tfstore_id = new TextField(300,40,"Mã cửa hàng:",font,false,"312-ADV",font,10);
        tfstore_id.setBounds(80,20,300,40);
        
        tfstore_address= new TextField(800,40,"Địa chỉ:",font,false,"số 312,đường An Dương Vương, phường 3, quận 5, TP.Hồ Chí Minh",font,10);
        tfstore_address.setBounds(80,80,800,40);
        
        tfstore_area = new TextField(250,40,"Khu vực:",font,false,"Miền Nam",font,10);
        tfstore_area.setBounds(430,20,250,40);
        
        tfstore_phonenumber = new TextField(350,40,"Số điện thoại:",font,false,"0976727851",font,10);
        tfstore_phonenumber.setBounds(730,20,350,40);
                
        panel.add(tfstore_id);
        panel.add(tfstore_address);
        panel.add(tfstore_area);
        panel.add(tfstore_phonenumber);
        
        return panel;
    }
    
    public JPanel addnhanvienpanel() throws IOException{
        JPanel panel = new JPanel(new BorderLayout(10,10));
        panel.setBorder(new FlatLineBorder(new Insets(10,60,10,10), null,0,0));
        
        pnlstore_info = store_infopanel();
        
        pnlemployee_info = new JPanel(null);
        pnlemployee_info.setBorder(new FlatLineBorder(new Insets(10,10,10,10), null,0,40));
        pnlemployee_info.setBackground(Color.white);
        
        employee_image = new JTextField();
        employee_image.setEditable(false);
        employee_image.setBounds(800,500,280,40);
        employee_image.putClientProperty("JTextField.placeholderText", "Đường dẫn hình ảnh");
        
        imageLabel = new JLabel("Drop image here", JLabel.CENTER);
        imageLabel.setBounds(800,80,320,420);
        imageLabel.setBorder(new LineBorder(new Color(117,117,117), 1));
        imageLabel.setTransferHandler(new TransferHandler() {
            public boolean canImport(TransferSupport support) {
                return support.isDataFlavorSupported(DataFlavor.javaFileListFlavor);
            }

            public boolean importData(TransferSupport support) {
                if (!canImport(support)) {
                    return false;
                }
                Transferable transferable = support.getTransferable();
                try {
                    List<File> files = (List<File>) transferable.getTransferData(DataFlavor.javaFileListFlavor);
                    if (!files.isEmpty()) {
                        String filePath = files.get(0).getName();
                        imageLabel.setIcon(scaleImage(files.get(0).getAbsolutePath(), 360, 460));
                        employee_image.setText(filePath);
                        return true;
                    }
                } catch (UnsupportedFlavorException | IOException ex) {
                    ex.printStackTrace();
                }
                return false;
            }
        });
        
        JButton browse = new JButton(new ImageIcon(ImageIO.read(new File("src\\Image\\OpenedFolder.png"))));
        browse.setBounds(1080,500,40,40);
        browse.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                if(editable){
                JFileChooser chooser = new JFileChooser("D:\\Y3_HK2\\CSDLPT-Convenience_store\\src\\Image");
                int returnValue = chooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    // File is selected
                    employee_image.setText(chooser.getSelectedFile().getName());
                    imageLabel.setIcon(scaleImage(chooser.getSelectedFile().getPath(), 360, 460));
                    }
                }
            }
        });
        
        pnlemployee_info.add(employee_image);
        pnlemployee_info.add(imageLabel);
        pnlemployee_info.add(browse);
        
        tfemployee_name = new TextField(420, 40,"Tên nhân viên:", font, editable, "Nhập tên nhân viên", font, 10);
        tfemployee_name.setLocation(200,50);
        
        dcemployee_birthday = new DateChooser(400,40,"Ngày sinh:",font,editable,font,10);
        dcemployee_birthday.setLocation(200,130);
        
        String[] option = {"Nam","Nữ"};
        cbemployee_gender = new CheckBox(350, 40, "Giới tính:", font,editable,option , font, 20);
        cbemployee_gender.setLocation(200,210);
        
        tfemployee_id = new TextField(420, 40, "CCCD/CMND:", font, editable, "Mã định danh", font, 10);
        tfemployee_id.setLocation(200,290);
        
        tfemployee_address = new TextField(420, 40, "Địa chỉ:", font, editable, "Địa chỉ", font, 10);
        tfemployee_address.setLocation(200,370);
        
        tfemployee_phonenumber = new TextField(420, 40, "Số điện thoại:", font, editable, "Số điện thoại", font, 10);
        tfemployee_phonenumber.setLocation(200,450);
        
        tfemployee_email = new TextField(420, 40,"Email:", font, editable, "Email nhân viên", font, 10);
        tfemployee_email.setLocation(200,530);
              
        pnlemployee_info.add(tfemployee_name);
        pnlemployee_info.add(dcemployee_birthday);
        pnlemployee_info.add(tfemployee_id);
        pnlemployee_info.add(tfemployee_address);
        pnlemployee_info.add(tfemployee_phonenumber);
        pnlemployee_info.add(cbemployee_gender);
        pnlemployee_info.add(tfemployee_email);
                
        pnladdemployee_footer = new JPanel(null);
        pnladdemployee_footer.setBorder(new FlatLineBorder(new Insets(10,10,10,10), null,0,40));
        pnladdemployee_footer.setPreferredSize(new Dimension(0,100));
        pnladdemployee_footer.setBackground(Color.white);
        
        btnapply = new JButton("Cập nhật");
        btnapply.setFont(font);
        btnapply.setForeground(Color.white);
        btnapply.setBackground(new Color(0,128,255));
        btnapply.setBounds(900,10,150,80);
        
        btncancel = new JButton("Hủy");
        btncancel.setFont(font);
        btncancel.setForeground(Color.white);
        btncancel.setBackground(Color.red);
        btncancel.setBounds(1070,10,150,80);
        btncancel.addMouseListener(this);
        
        pnladdemployee_footer.add(btnapply);
        pnladdemployee_footer.add(btncancel);
        
        panel.add(pnlstore_info,BorderLayout.NORTH);
        panel.add(pnlemployee_info,BorderLayout.CENTER);
        if(editable)
            panel.add(pnladdemployee_footer,BorderLayout.SOUTH);
        
        return panel;
    }
    
    public ImageIcon scaleImage(String path,int width,int height){
        ImageIcon imageIcon = new ImageIcon(path);
        Image img = imageIcon.getImage().getScaledInstance(300, 400, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(img);
        return  imageIcon;
    }
    
    public JPanel eastpanel() throws IOException{
        JPanel panel = new JPanel(null);
        panel.setPreferredSize(new Dimension(50,0));
        
        pnlgoback = new JPanel(new BorderLayout());
        pnlgoback.setBounds(0,10,80,40);
        pnlgoback.setBorder(new FlatLineBorder(new Insets(0,10,0,0),null,0,40));
        pnlgoback.setBackground(btn_color);
        pnlgoback.addMouseListener(this);
        
        goback = new JLabel(new ImageIcon(ImageIO.read(new File("src\\Image\\Back.png"))));
        goback.setHorizontalAlignment(JLabel.LEFT);
        goback.setForeground(Color.white);
        goback.setFont(font);
       
        pnlgoback.add(goback,BorderLayout.CENTER);
        
        
        panel.add(pnlgoback);
        
        return panel;
    }
    
    public void setData(){
        EmployeeDLL epl = new EmployeeDLL();
        
    }
    
    public EmployeeManagement(EmployeeUI nvui,Boolean editable) throws IOException{
        initcomponent(nvui,editable);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==pnlgoback || e.getSource()==btncancel){
            nhanvienui.removeAll();
            nhanvienui.add(nhanvienui.pnlmain,BorderLayout.CENTER);
            nhanvienui.repaint();
            nhanvienui.validate(); 
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource()==pnlgoback){
            pnlgoback.setBackground(btn_color_hover);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource()==pnlgoback){
            pnlgoback.setBackground(btn_color);
        }
    }

    
}
