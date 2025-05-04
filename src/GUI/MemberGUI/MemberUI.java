/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI.MemberGUI;

import com.formdev.flatlaf.ui.FlatLineBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import sharedComponents.DateChooser;
import sharedComponents.TextField;

/**
 *
 * @author NAME
 */
public class MemberUI extends JPanel implements MouseListener{
    JFrame frame;
    String namepage = "Thành Viên";
    JPanel panelsearch,panelmain,panelinfo;
    JPanel pnltbl_header,pnlmember_info;
    DateChooser dcbirthday,dcjoinin;
    JLabel lbltbl_header;
    JButton add;
    DefaultTableModel model;
    JTable tbllist;
    JComboBox cbbadvent;
    JTextField txtsearchfield;
    JDialog dialog;
    JButton detail,update,delete;
    Color red = new Color(229, 57, 53);
    Color blue = new Color(33, 150, 243);
    HashSet<String> selected = new HashSet<>();
    TextField[] lblinfo = new TextField[8];
    String[] lblinfo_tag = {"Mã thành viên","Họ & Tên","Giới tính","Ngày sinh","Ngày tham gia","SDT","Email","Điểm"};
    public void initcomponent(JFrame frame) throws IOException{
        this.frame = frame;
        this.setLayout(new BorderLayout());
        this.setBorder(new FlatLineBorder(new Insets(10,10,10,10),null,0,0));
        
        panelsearch = searchpanel();
        panelmain = listpanel();
        panelinfo = new JPanel();
        
        this.add(panelsearch,BorderLayout.NORTH);
        this.add(panelmain,BorderLayout.CENTER);
    }
    
    public JPanel listpanel(){
        JPanel panel = new JPanel(new BorderLayout(10,0));
        panel.setBorder(new FlatLineBorder(new Insets(10,0,0,0),null,0,0));
        
        pnltbl_header = new JPanel(new BorderLayout());
        pnltbl_header.setBorder(new FlatLineBorder(new Insets(10,20,10,20),null,0,0));
        pnltbl_header.setPreferredSize(new Dimension(0,60));
        pnltbl_header.setBackground(Color.white);
        
        lbltbl_header = new JLabel("Bảng thành viên");
        lbltbl_header.setFont(new Font("Roboto",Font.CENTER_BASELINE,22));
        lbltbl_header.setHorizontalAlignment(JLabel.CENTER);
//        lbltbl_header.setBounds(10,10,250,40);
        
        add = new JButton("Thêm thành viên +");
        add.setFont(new Font("Roboto",Font.BOLD,14));
        add.setBackground(blue);
        add.setForeground(Color.white);
        add.addMouseListener(this);
        
        pnltbl_header.add(lbltbl_header,BorderLayout.WEST);
        pnltbl_header.add(add,BorderLayout.EAST);        
        
        model = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column) {
        //all cells false
        return false;
        }
        };
        tbllist = new JTable(model);
        tbllist.setFocusable(false);
        
        model.addColumn("#");
        model.addColumn("Mã thành viên");
        model.addColumn("Tên thành viên");
        model.addColumn("Giới tính");
        model.addColumn("Ngày sinh");
        model.addColumn("Ngày cập nhật");
        
        Object[][] ts = new Object[][]{
            {false,"123","VU Hieu","Nam","01/08/2001","23/04/2020"},
            {false,"124","DNA14","Nam","01/08/2001","23/04/2020"},
            {false,"125","DNA14","Nam","01/08/2001","23/04/2020"},
            {false,"126","DNA14","Nam","01/08/2001","23/04/2020"},
            {false,"127","DNA14","Nam","01/08/2001","23/04/2020"},
            {false,"128","DNA14","Nam","01/08/2001","23/04/2020"},
            {false,"129","DNA14","Nam","01/08/2001","23/04/2020"},
            {false,"130","DNA14","Nam","01/08/2001","23/04/2020"},
            {false,"131","DNA14","Nam","01/08/2001","23/04/2020"}
        };
        
        for(int i=0;i<ts.length;i++){
            model.addRow(ts[i]);
        }
        
        tbllist.getColumnModel().getColumn(0).setPreferredWidth(5);
        tbllist.getColumnModel().getColumn(0).setCellRenderer(tbllist.getDefaultRenderer(Boolean.class));

        // Thiết lập editor cho cột check box
        tbllist.getColumnModel().getColumn(0).setCellEditor(tbllist.getDefaultEditor(Boolean.class));
        tbllist.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                int index = tbllist.getSelectedRow();
                if(e.getClickCount()>1 && tbllist.getSelectedColumn()!=0){
                    showActionPanel(e.getPoint(), e.getLocationOnScreen());
                }
                selectedRow(index);
                if(!selected.isEmpty()){
                    add.setText("Xóa");
                    add.setBackground(red);
                }
                else{
                    add.setText("Thêm thành viên +");
                    add.setBackground(blue);
                }
            }
        });
        
        
        JScrollPane scp = new JScrollPane(tbllist);
        
        panel.add(pnltbl_header,BorderLayout.NORTH);
        panel.add(scp,BorderLayout.CENTER);
        
        return panel;
    }
    
    public void selectedRow(int index){
        if((Boolean)tbllist.getValueAt(index, 0)==true)
            selected.add((String)tbllist.getValueAt(index, 1));
        else
            selected.remove((String)tbllist.getValueAt(index, 1));
        System.out.println("/--------------");
        for(String a : selected){
            System.out.println(a);
        }

    }
    
    public void showActionPanel(Point tablepoint,Point mousepoint){
        int row = tbllist.rowAtPoint(tablepoint);
        String id = (String) tbllist.getValueAt(row, 1);
        String name = (String) tbllist.getValueAt(row, 2);
        showDialogAtMousePosition(name,id, mousepoint);
    }
    
    private void showDialogAtMousePosition(String name,String id, Point mousePosition) {
        dialog = new JDialog(frame,"Actions",true);
        dialog.setLayout(new BorderLayout());
        dialog.setPreferredSize(new Dimension(150,200));
        
        JPanel panel1 = new JPanel(new FlowLayout());
        panel1.setPreferredSize(new Dimension(0,30));

        JLabel idLabel = new JLabel("ID: " + id);
        JLabel nameLabel = new JLabel("Tên: " + name);

        panel1.add(idLabel);
        panel1.add(nameLabel);
        
        JPanel panel2 = new JPanel(new GridLayout(3,0,0,0));
        panel2.setBorder(new FlatLineBorder(new Insets(10,20,10,20), null,0,0));
        
        detail = new JButton("Chi tiết");
        detail.addMouseListener(this); 
                
        update = new JButton("Sửa");
        update.addMouseListener(this);
        
        delete = new JButton("Xóa");
        delete.setBackground(Color.white);
        delete.setForeground(red);
        delete.addMouseListener(this);
        
        panel2.add(detail);
        panel2.add(update);
        panel2.add(delete);
        
        dialog.add(panel1,BorderLayout.NORTH);
        dialog.add(panel2,BorderLayout.CENTER);

        // Set location of the dialog based on mouse position
        dialog.setLocation(mousePosition);

        dialog.pack();
        dialog.setVisible(true);
    }
    
     public void switchpanel(JPanel pnl){
        this.removeAll();
        this.add(pnl,BorderLayout.CENTER);
        this.repaint();
        this.validate();
    }
    
    public JPanel searchpanel(){
        JPanel panel = new JPanel(null);
        panel.setPreferredSize(new Dimension(0,60));
//        panel.setBorder(new FlatLineBorder(new Insets(0,0,0,0),null,0,40));
        panel.setBackground(Color.white);
        
        dcbirthday = new DateChooser(250, 40, "Ngày sinh:", null, true, null, 10);
        dcbirthday.setLocation(50,10);
        
        dcjoinin = new DateChooser(250, 40, "Ngày vào:", null, true, null, 10);
        dcjoinin.setLocation(420,10);
        
        txtsearchfield = new JTextField();
        txtsearchfield.putClientProperty("JTextField.placeholderText", "TÌm kiếm....");
        txtsearchfield.setBounds(840,10,350,40);
        
        String[] option = {"Theo tên","Theo mã","Theo giới tính"};
        cbbadvent = new JComboBox(option);
        cbbadvent.setBounds(1190,10,130,40);
        
        panel.add(dcbirthday);
        panel.add(dcjoinin);
//        panel.add(lblchinhanh);
//        panel.add(cbbchinhanh);
        panel.add(txtsearchfield);
        panel.add(cbbadvent);
        
        return panel;
    }
    
    public JPanel member_infomation(Boolean editable) throws IOException{
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new FlatLineBorder(new Insets(10,10,0,0),null,0,0));
        panel.setPreferredSize(new Dimension(400,0));

        pnlmember_info = new JPanel(null);
        pnlmember_info.setBackground(Color.white); 
        
        JButton close = new JButton(new ImageIcon(ImageIO.read(new File("src\\Image\\Close.png"))));
        close.setBounds(340,10,40,40);
        close.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                    panelinfo.setVisible(false);
            }
        });
        pnlmember_info.add(close);
        
        if(editable){
            JButton update = new JButton("Cập nhật");
            update.setFont(new Font("Roboto",Font.CENTER_BASELINE,14));
            update.setForeground(blue);
            update.setBounds(150,550,100,40);
            update.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e){
                    //----Cập nhật
                    JOptionPane.showConfirmDialog(panelmain, "Bạn muốn cập nhật thông tin trên?", "Confirm", JOptionPane.YES_NO_OPTION);
                }
            });
            
            JButton cancel = new JButton("Hủy");
            cancel.setFont(new Font("Roboto",Font.CENTER_BASELINE,14));
            cancel.setForeground(Color.white);
            cancel.setBackground(red);
            cancel.setBounds(260,550,80,40);
            cancel.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e){
                    panelinfo.setVisible(false);
                }
            });
            pnlmember_info.add(update);
            pnlmember_info.add(cancel);
        }
        
        Font lblfont  = new Font("Roboto",Font.CENTER_BASELINE,16);
        Font datafont  = new Font("Roboto",Font.CENTER_BASELINE,14);
        for(int i = 0;i<lblinfo.length;i++){
            lblinfo[i] = new TextField(300, 40, lblinfo_tag[i]+":", lblfont, editable, lblinfo_tag[i], datafont, 2);
            lblinfo[i].setLocation(35,65+(i*60));
            pnlmember_info.add(lblinfo[i]);
        }
        
        panel.add(pnlmember_info,BorderLayout.CENTER);
        return panel;
    }
    
    public MemberUI(JFrame frame) throws IOException{
        initcomponent(frame);
    }
    
    public String getNamepage() {
        return namepage;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == detail){
            this.remove(panelinfo);
            try {
                panelinfo = member_infomation(false);
            } catch (IOException ex) {
                Logger.getLogger(MemberUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.add(panelinfo,BorderLayout.EAST);
            this.repaint();
            this.validate();
            panelinfo.setVisible(true);
            dialog.dispose();
        }
        if(e.getSource() == update){
            this.remove(panelinfo);
            try {
                panelinfo = member_infomation(true);
            } catch (IOException ex) {
                Logger.getLogger(MemberUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.add(panelinfo,BorderLayout.EAST);
            this.repaint();
            this.validate();
//            panelinfo.setVisible(true);
            dialog.dispose();
        }
        if (e.getSource()==add && add.getText()=="Thêm thành viên +") {
            this.remove(panelinfo);
            try {
                panelinfo = member_infomation(true);
            } catch (IOException ex) {
                Logger.getLogger(MemberUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.add(panelinfo,BorderLayout.EAST);
            this.repaint();
            this.validate();
            panelinfo.setVisible(true);
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
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
}
