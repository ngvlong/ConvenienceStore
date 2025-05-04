/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI.EmployeeGUI;

import DAO.EmployeeDAO;
import DLL.EmployeeDLL;
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
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
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

/**
 *
 * @author NAME
 */
public class EmployeeUI extends JPanel implements MouseListener{
    JFrame frame;
    JDialog dialog ;
    String namepage = "Nhân Viên";
    JPanel pnltbl,pnlmain;
    JPanel pnlsearch,pnltbl_header;
    JLabel lblchinhanh,lbltbl_header;
    DateChooser dcbirthday,dcjoinin;
    JTextField txtsearchfield;
    JComboBox cbbadvent,cbbchinhanh;
    DefaultTableModel model ;
    JTable tbllist;
    JButton detail,delete,update,add;
    Color red = new Color(229, 57, 53);
    HashSet<String> selected = new HashSet<>();
    public void initcomponent(JFrame frame) {
        this.setLayout(new BorderLayout());
        this.setBorder(new FlatLineBorder(new Insets(10,10,10,10),null,0,0));
        this.frame = frame;
        pnltbl = listpanel();
        pnlmain = new JPanel(new BorderLayout());
        pnlsearch = searchpanel();
        pnlmain.add(pnlsearch, BorderLayout.NORTH);
        pnlmain.add(pnltbl,BorderLayout.CENTER);
        
        this.add(pnlmain,BorderLayout.CENTER);
    }

    public String getNamepage() {
        return namepage;
    }

    public EmployeeUI(JFrame fr) {
        initcomponent(fr);
    }
    
    
    public JPanel listpanel(){
        JPanel panel = new JPanel(new BorderLayout(10,0));
        panel.setBorder(new FlatLineBorder(new Insets(10,0,0,0),null,0,0));
        
        pnltbl_header = new JPanel(new BorderLayout());
        pnltbl_header.setBorder(new FlatLineBorder(new Insets(10,20,10,20),null,0,0));
        pnltbl_header.setPreferredSize(new Dimension(0,60));
        pnltbl_header.setBackground(Color.white);
        
        lbltbl_header = new JLabel("Bảng nhân viên");
        lbltbl_header.setFont(new Font("Roboto",Font.CENTER_BASELINE,22));
        lbltbl_header.setHorizontalAlignment(JLabel.CENTER);
        lbltbl_header.setBounds(10,10,250,40);
        
        add = new JButton("Thêm nhân viên +");
        add.setFont(new Font("Roboto",Font.BOLD,14));
        add.setBackground(new Color(33, 150, 243));
        add.setForeground(Color.white);
        add.setBounds(1120,10,160,40);
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
        model.addColumn("#");
        model.addColumn("Mã NV");
        model.addColumn("Tên Nhân Viên");
        model.addColumn("Chi nhánh");
        model.addColumn("Giới tính");
        model.addColumn("Ngày sinh");
        model.addColumn("Ngày cập nhật");
        EmployeeDAO empdao = new EmployeeDAO();
        ArrayList<EmployeeDLL> ts = empdao.selectAll("TDT");
        String gender;
        for(EmployeeDLL e : ts){
            gender = (e.getGender()==1) ? "Nam" : "Nữ";
            model.addRow(new Object[]{false,e.getId(),e.getName(),e.getChinhanh(),gender,e.getBirthday(),e.getJoinindate()});
        }
        
        tbllist = new JTable(model);
        tbllist.setFocusable(false);
        tbllist.getColumnModel().getColumn(0).setPreferredWidth(5);
   
        tbllist.getColumnModel().getColumn(0).setCellRenderer(tbllist.getDefaultRenderer(Boolean.class));

        // Thiết lập editor cho cột check box
        tbllist.getColumnModel().getColumn(0).setCellEditor(tbllist.getDefaultEditor(Boolean.class));

        tbllist.addMouseListener(this);
        
        JScrollPane scp = new JScrollPane(tbllist);
        
        panel.add(pnltbl_header,BorderLayout.NORTH);
        panel.add(scp,BorderLayout.CENTER);
        
        return panel;
    }
        
    public JPanel searchpanel(){
        JPanel panel = new JPanel(null);
        panel.setPreferredSize(new Dimension(0,60));
        panel.setBackground(Color.white);
        
        dcbirthday = new DateChooser(250, 40, "Ngày sinh:", null, true, null, 10);
        dcbirthday.setLocation(10,10);
        
        dcjoinin = new DateChooser(250, 40, "Ngày vào:", null, true, null, 10);
        dcjoinin.setLocation(280,10);
        
        lblchinhanh = new JLabel("Chi Nhánh");
        lblchinhanh.setHorizontalAlignment(JLabel.CENTER);
        lblchinhanh.setBounds(550,10,90,40);
        
        String[] i = {"123-NCD","985-TVO","772-TN"};
        cbbchinhanh = new JComboBox(i);
        cbbchinhanh.setBounds(640,10,150,40);
        
        txtsearchfield = new JTextField();
        txtsearchfield.putClientProperty("JTextField.placeholderText", "TÌm kiếm....");
        txtsearchfield.setBounds(840,10,350,40);
        
        String[] option = {"Theo tên","Theo mã","Theo quê quán","Theo giới tính"};
        cbbadvent = new JComboBox(option);
        cbbadvent.setBounds(1190,10,130,40);
        
        panel.add(dcbirthday);
        panel.add(dcjoinin);
        panel.add(lblchinhanh);
        panel.add(cbbchinhanh);
        panel.add(txtsearchfield);
        panel.add(cbbadvent);
        
        return panel;
    }
    
    public void switchpanel(JPanel pnl){
        this.removeAll();
        this.add(pnl,BorderLayout.CENTER);
        this.repaint();
        this.validate();
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
        detail.addMouseListener(new MouseAdapter() {
             public void mouseClicked(MouseEvent e) {
                try {
                    switchpanel(new EmployeeManagement(EmployeeUI.this,false));
                } catch (IOException ex) {
                    Logger.getLogger(EmployeeUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                dialog.dispose();
            }
            
        });
        update = new JButton("Sửa");
        update.addMouseListener(new MouseAdapter() {
             public void mouseClicked(MouseEvent e) {
                try {
                    switchpanel(new EmployeeManagement(EmployeeUI.this,true));
                } catch (IOException ex) {
                    Logger.getLogger(EmployeeUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                dialog.dispose();
            }
            
        });
        delete = new JButton("Xóa");
        delete.setBackground(Color.white);
        delete.setForeground(red);
        
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
    
    public void selectedRow(int index){
        if((Boolean)tbllist.getValueAt(index, 0)==true){
//                if (!selected.contains(tbllist.getValueAt(index, 1))) {
            selected.add((String)tbllist.getValueAt(index, 1));
//                }
        }
        else{
            selected.remove((String)tbllist.getValueAt(index, 1));
        }
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

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==add )
            if(add.getText()=="Thêm nhân viên +"){
                try {
                    switchpanel(new EmployeeManagement(this,true));
                } catch (IOException ex) {
                    Logger.getLogger(EmployeeUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else
                JOptionPane.showConfirmDialog(this, "Are you sure to delete?","Confirm",JOptionPane.YES_NO_OPTION);
        
        if(e.getSource()==tbllist){
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
                add.setText("Thêm nhân viên +");
                add.setBackground(new Color(33, 150, 243));
            }
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
