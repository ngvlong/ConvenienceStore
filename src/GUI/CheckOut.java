/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import com.formdev.flatlaf.ui.FlatLineBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NAME
 */
public class CheckOut extends JPanel implements MouseListener{
    Color btncolor = new Color(30, 133, 222);
    String namepage = "Check Out";
    JPanel pnlstafflist,pnlbillinfo,pnlsearch,pnltable,search,pnlproductinfo,pnlservice,pnltotal;
    JTable table,searchtable ;
    JLabel lblmasp,lbltensp,lbldonvi,lblimg,lblthanhtien,lbltongcong,lbldoidiem,thanhtien,tongcong,doidiem,lblthanhvien;
    JScrollPane scptable,scpsearch;
    JTextField txtsearch,txtamount,txtthanhvien,txtpoint;
    JTextPane txtmota;
    JButton btnsearch,btnadd,btndelete,btnapply,btnmember,btnthanhtoan,btnhuythanhtoan;
    Color linebordercolor=new Color(194,194,194);
    DefaultTableModel model,searchmodel;
    JLabel lblmembername,lblphonenumber,lblemail,lblcreditpoint;

    public void initcomponent() throws IOException {
        this.setLayout(new BorderLayout());
        
        pnlstafflist = new JPanel(new BorderLayout());
        
        pnlsearch = SearchPanel();
        
        pnltable = TablePanel();
                
        pnlstafflist.add(pnlsearch,BorderLayout.NORTH);
        pnlstafflist.add(pnltable,BorderLayout.CENTER);
        
        pnlbillinfo = new JPanel(new BorderLayout());
        pnlbillinfo.setPreferredSize(new Dimension(400,0));
        pnlbillinfo.setBorder(new FlatLineBorder(new Insets(10,5,8,12),null,0,0));
        
        pnlbillinfo.add(BillPanel(),BorderLayout.CENTER);
                
        
        this.add(pnlstafflist,BorderLayout.CENTER);
        this.add(pnlbillinfo,BorderLayout.EAST);
        
        
    }
    
    public void getCamera(JTextField t){
        
    }
    
    public JPanel BillPanel(){
        JPanel panel = new JPanel(null);
        Font font1 = new Font("",Font.CENTER_BASELINE,22);
        Font font2 = new Font("",Font.ITALIC,20);
        panel.setBackground(Color.white);
        panel.setBorder(new LineBorder(linebordercolor,1,false));
        
        pnlservice = new JPanel(null);
        pnlservice.setBorder(new MatteBorder(0,0,1,0,linebordercolor));
        pnlservice.setBackground(Color.white);
        pnlservice.setBounds(2,1,379,380);
        
        lblthanhvien = new JLabel("Thành viên");
        lblthanhvien.setBounds(15,15,150,40);
        lblthanhvien.setFont(font2);
        
        txtthanhvien = new JTextField();
        txtthanhvien.putClientProperty("JTextField.placeholderText", "Nhập mã thành viên");
        txtthanhvien.setBounds(15,60,200,40);
        
        btnmember = new JButton("Tìm");
        btnmember.setForeground(btncolor);
        btnmember.setBounds(220,60,70,40);
        
        pnlservice.add(CustomerInformation("001"));
        pnlservice.add(lblthanhvien);
        pnlservice.add(txtthanhvien);
        pnlservice.add(btnmember);
        
        pnltotal = new JPanel(null);
        pnltotal.setBounds(2,382,379,510);
        pnltotal.setBackground(Color.white);
        
        lbltongcong = new JLabel("Tổng cộng:");
        lbltongcong.setFont(font1);
        lbltongcong.setBounds(15,20,150,40);
        
        tongcong = new JLabel("150000vnd");
        tongcong.setFont(font2);
        tongcong.setBounds(180,20,200,40);
        
        lbldoidiem = new JLabel("Đổi điểm:");
        lbldoidiem.setFont(font1);
        lbldoidiem.setBounds(15,80,150,40);
        
        doidiem = new JLabel("100");
        doidiem.setFont(font2);
        doidiem.setBounds(180,80,200,40);
        
        lblthanhtien = new JLabel("Thành tiền:");
        lblthanhtien.setFont(font1);
        lblthanhtien.setBounds(15,140,150,40);
        
        thanhtien = new JLabel("140000vnd");
        thanhtien.setFont(font2);
        thanhtien.setBounds(180,140,200,40);
        
        Font btnfont = new Font("",Font.BOLD,20);
        btnthanhtoan = new JButton("Thanh toán");
        btnthanhtoan.setFont(btnfont);
        btnthanhtoan.setForeground(btncolor);
        btnthanhtoan.setBounds(25,450,160,50);
        btnthanhtoan.addMouseListener(this);
        
        btnhuythanhtoan = new JButton("Hủy");
        btnhuythanhtoan.setFont(btnfont);
        btnhuythanhtoan.setBackground(Color.red);
        btnhuythanhtoan.setForeground(Color.white);
        btnhuythanhtoan.setBounds(200,450,160,50);
        
        pnltotal.add(lbltongcong);
        pnltotal.add(tongcong);
        pnltotal.add(lbldoidiem);
        pnltotal.add(doidiem);
        pnltotal.add(lblthanhtien);
        pnltotal.add(thanhtien);
        pnltotal.add(btnthanhtoan);
        pnltotal.add(btnhuythanhtoan);
        
        panel.add(pnlservice);
        panel.add(pnltotal);
        
        return panel;
    }
    
    public JPanel CustomerInformation(String member_id){
        String member = "";
        int point = 100;
        
        JPanel panel = new JPanel(null);
        panel.setBounds(10,120,360,250);
        panel.setBorder(new FlatLineBorder(new Insets(5,5,5,5),linebordercolor,1,40 ));
        
        lblmembername = new JLabel("Tên: "+member);
        lblmembername.setBounds(15,5,230,40);
        
        lblphonenumber = new JLabel("SDT: "+member);
        lblphonenumber.setBounds(15,50,230,40);
        
        lblemail = new JLabel("Email: "+member);
        lblemail.setBounds(15,95,230,40);
        
        lblcreditpoint = new JLabel("Điểm: "+point);
        lblcreditpoint.setBounds(15,140,230,40);
        
        txtpoint = new JTextField();
        txtpoint.putClientProperty("JTextField.placeholderText", "Nhập điểm");
        txtpoint.setBounds(10,190,215,40);
        
        btnapply = new JButton("Áp dụng");
        btnapply.setForeground(btncolor);
        btnapply.setBounds(230,190,120,40);
        
        panel.add(lblmembername);
        panel.add(lblemail);
        panel.add(lblphonenumber);
        panel.add(lblcreditpoint);
        panel.add(txtpoint);
        panel.add(btnapply);
        
        return panel;
    }
    
    public JPanel TablePanel(){
        model = new DefaultTableModel();
        model.addColumn("Stt");
        model.addColumn("Mã sản phẩm");
        model.addColumn("Tên sản phẩm");
        model.addColumn("Đơn giá");
        model.addColumn("Số lượng");
        model.addColumn("Khuyến mãi");
        model.addColumn("Thành tiền");
        
        model.addRow(new Object[]{"1","123","VCL","23","2","","23"});
        model.addRow(new Object[]{"1","123","VCL","23","2","","23"});
        
        table = new JTable(model);
//        table.setFocusable(false);
        
        scptable = new JScrollPane(table);
        
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new FlatLineBorder(new Insets(5,10,5,10),null,0,0));
        panel.add(scptable,BorderLayout.CENTER);
        return panel;
    }
    
    public JPanel SearchPanel() throws IOException{
        
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new FlatLineBorder(new Insets(10,12,5,12),null,0,0));
        panel.setPreferredSize(new Dimension(0,250));
        
        search = new JPanel(null);
        search.setBackground(Color.white);
        search.setBorder(new LineBorder(linebordercolor,1,false));
        
        txtsearch = new JTextField();
        txtsearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
        txtsearch.putClientProperty("JTextField.placeholderText", "Tìm theo mã sản phẩm hoặc tên sản phẩm");
        txtsearch.setBounds(70, 10, 350, 50);
      
        btnsearch = new JButton(new ImageIcon(ImageIO.read(new File("src\\Image\\Search.png"))));
        btnsearch.setBounds(420, 10, 50, 50);

        searchmodel = new DefaultTableModel();
        searchmodel.addColumn("Mã sản phẩm");
        searchmodel.addColumn("Tên sản phẩm");
        
        searchtable = new JTable(searchmodel);
        
        scpsearch = new JScrollPane(searchtable);
        scpsearch.setBounds(10,65,500,165);
        
        pnlproductinfo = new JPanel(new BorderLayout());
        pnlproductinfo.setBackground(Color.white);
        pnlproductinfo.setBorder(new MatteBorder(0,1,0,0,linebordercolor));
        pnlproductinfo.setBounds(520,2,437,231);
        
        setProductinfo("SP001", "Poca Lay's", "680g", "Làm từ khoai tây tự nhiên với các gia vị chiết suất từ thảo mộc.", null);
        
        search.add(txtsearch);
        search.add(btnsearch);
        search.add(scpsearch);
        search.add(pnlproductinfo);
        
        panel.add(search,BorderLayout.CENTER);
        
        return panel;
    }
    
    public void setProductinfo(String masp,String tensp,String donvi,String mota,String img_path) throws IOException{
        JPanel panel = new JPanel(null);
        Font font = new Font("",Font.CENTER_BASELINE,16);
        pnlproductinfo.removeAll();
        panel.setBackground(Color.white);
        if(img_path==null)
            img_path = "src\\Image\\4488550.png";
        
        lblmasp = new JLabel("Mã: "+masp);
        lblmasp.setBounds(5,5,240,30);
        lblmasp.setFont(font);
        lbltensp = new JLabel("Tên: "+tensp);
        lbltensp.setBounds(5,40,240,30);
        lbltensp.setFont(font);
        lbldonvi = new JLabel("Đơn vị: "+donvi);
        lbldonvi.setBounds(5,75,240,30);
        lbldonvi.setFont(font);
        txtmota = new JTextPane();
        txtmota.setFont(font);
        txtmota.setText("Mô tả: "+mota);
        txtmota.setEditable(false);
        txtmota.setBounds(0,110,240,70);
        txtmota.setBackground(Color.white);
        lblimg = new JLabel(new ImageIcon(ImageIO.read(new File(img_path))));
        lblimg.setBounds(245,0,200,230);
        
        txtamount = new JTextField("1");
        txtamount.putClientProperty("JTextField.placeholderText", "Nhập số lượng sản phẩm");
        txtamount.setBounds(5,185,110,35);
        
        btnadd = new JButton("Thêm");
        btnadd.setBackground(Color.white);
        btnadd.setForeground(btncolor);
        btnadd.setBounds(120,185,65,35);
        
        btndelete = new JButton("Xóa");
        btndelete.setBackground(Color.red);
        btndelete.setForeground(Color.white);
        btndelete.setBounds(185,185,65,35);
        
        panel.add(lblmasp);
        panel.add(lbltensp);
        panel.add(lbldonvi);
        panel.add(txtmota);
        panel.add(lblimg);
        panel.add(txtamount);
        panel.add(btnadd);
        panel.add(btndelete);
        
        pnlproductinfo.add(panel);
        pnlproductinfo.repaint();
        pnlproductinfo.validate();
    }
    
    public CheckOut() throws IOException {
        initcomponent();
    }

    public String getNamepage() {
        return namepage;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==btnthanhtoan){
            int i = table.getSelectedRow();
            System.out.println(table.getValueAt(i, 6));
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
