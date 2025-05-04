/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;
import com.formdev.flatlaf.ui.FlatLineBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class ProductUI extends JPanel{
    String Namepage = "Products";
    JPanel pnlstafflist,pnlbillinfo,pnlsearch,pnltable,search,total,pnlproductinfo,pnlservice,pnlkhuyenmai,pnlprodinfo,pnlchangeinfo;
    JTable table,searchtable,tblkhuyenmai ;
    JLabel lblmasp,lbltensp,lbldonvi,lblimg,lblthanhtien,lbltongtien,thanhtien,tongtien,lblthanhvien,lblkhuyenmai;
    JScrollPane scptable,scpsearch,scpkhuyenmai;
    JTextField txtsearch,txtamount,txtkhuyenmai,txtthanhvien;
    JTextPane txtmota;
    JButton btnsearch,btnadd,btnapply,btnaddprod,btndelprod,btnchangeprod;
    public void initcomponent() throws IOException{
        this.setLayout(new BorderLayout());
        
        pnlstafflist = new JPanel(new BorderLayout());
        
        pnlsearch = SearchPanel();
        
        pnltable = TablePanel();
                
        pnlstafflist.add(pnlsearch,BorderLayout.NORTH);
        pnlstafflist.add(pnltable,BorderLayout.CENTER);
        

        
        pnlprodinfo = new JPanel(new BorderLayout());
        pnlprodinfo.setPreferredSize(new Dimension(400,0));
        pnlprodinfo.setBorder(new FlatLineBorder(new Insets(10,5,8,12),null,0,0));
        
        pnlprodinfo.add(ProdInfoPanel(),BorderLayout.CENTER);
                
        
        this.add(pnlstafflist,BorderLayout.CENTER);
        this.add(pnlprodinfo,BorderLayout.EAST);
        
    }
    
    public JPanel ProdInfoPanel() {
        JPanel panel = new JPanel(null);
        Font font1 = new Font("",Font.CENTER_BASELINE,22);
        Font font2 = new Font("",Font.CENTER_BASELINE,20);
        panel.setBackground(Color.white);
        panel.setBorder(new LineBorder(new Color(194,194,194),1,false));
//        
//        pnlservice = new JPanel(null);
//        pnlservice.setBorder(new MatteBorder(1,1,1,1,new Color(194,194,194)));
//        pnlservice.setBackground(Color.white);
//        pnlservice.setBounds(2,1,379,380);
                
        pnlproductinfo = new JPanel(new BorderLayout());
        pnlproductinfo.setBackground(Color.white);
        pnlproductinfo.setBorder(new MatteBorder(1,1,1,1,new Color(194,194,194)));
        pnlproductinfo.setBounds(15,30,350,400);
        panel.add(pnlproductinfo,BorderLayout.NORTH);
        
        try {
            setProductinfo("SP001", "Poca Lay's", "680g", "Làm từ khoai tây tự nhiên với các gia vị chiết suất từ thảo mộc.", null);
        } catch (IOException ex) {
            Logger.getLogger(ProductUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        pnlchangeinfo = new JPanel(null);
        pnlchangeinfo.setBackground(Color.white);
        pnlchangeinfo.setBorder(new MatteBorder(1,1,1,1,new Color(194,194,194)));
        pnlchangeinfo.setBounds(15,470,350,400);
//        pnlchangeinfo.setLayout(new BoxLayout(pnlchangeinfo, BoxLayout.Y_AXIS));
        
        btnaddprod = new JButton("Thêm");
        btnaddprod.setBackground(Color.WHITE);
        btnaddprod.setForeground(new Color(30, 133, 222));
        btnaddprod.setBounds(120,50,90,35);
        
        btnchangeprod = new JButton("Sửa");
        btnchangeprod.setBackground(Color.WHITE);
        btnchangeprod.setForeground(new Color(30, 133, 222));
        btnchangeprod.setBounds(120,110,90,35);
        
        btndelprod = new JButton("Xóa");
        btndelprod.setBackground(Color.WHITE);
        btndelprod.setForeground(new Color(30, 133, 222));
        btndelprod.setBounds(120,170,90,35);
        
        pnlchangeinfo.add(btnaddprod);
//        pnlchangeinfo.add(Box.createRigidArea(new Dimension(100, 20))); 
        pnlchangeinfo.add(btnchangeprod);
//        pnlchangeinfo.add(Box.createRigidArea(new Dimension(100, 20))); 
        pnlchangeinfo.add(btndelprod);

        panel.add(pnlchangeinfo,BorderLayout.SOUTH);
//        panel.add(pnlservice);
        
        return panel;
    }
    
    public JPanel TablePanel(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("STT");
        model.addColumn("Mã sản phẩm");
        model.addColumn("Tên sản phẩm");
        model.addColumn("Loại hàng");
        model.addColumn("Đơn giá");
        model.addColumn("Số lượng");
        model.addColumn("Khuyến mãi");
        model.addColumn("Trạng thái");
        
        table = new JTable(model);
        table.setFocusable(false);
        
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
        search.setBorder(new LineBorder(new Color(194,194,194),1,false));
        
        txtsearch = new JTextField();
        txtsearch.putClientProperty("JTextField.placeholderText", "Tìm theo mã sản phẩm hoặc tên sản phẩm");
        txtsearch.setBounds(70, 10, 350, 50);
      
        btnsearch = new JButton(new ImageIcon(ImageIO.read(new File("src\\Image\\Search.png"))));
        btnsearch.setBounds(420, 10, 50, 50);

        
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Mã sản phẩm");
        model.addColumn("Tên sản phẩm");
        
        searchtable = new JTable(model);
        
        scpsearch = new JScrollPane(searchtable);
        scpsearch.setBounds(10,65,500,165);

        
        search.add(txtsearch);
        search.add(btnsearch);
        search.add(scpsearch);

        
        panel.add(search,BorderLayout.CENTER);
        
        return panel;
    }
    
    public void setProductinfo(String masp,String tensp,String donvi,String mota,String img_path) throws IOException{
        JPanel panel = new JPanel(null);
        pnlproductinfo.removeAll();
        panel.setBackground(Color.white);
        if(img_path==null)
            img_path = "src\\Image\\4488550.png";
        
        lblmasp = new JLabel("Mã: "+masp);
        lblmasp.setBounds(5,5,240,30);
        lbltensp = new JLabel("Tên: "+tensp);
        lbltensp.setBounds(5,40,240,30);
        lbldonvi = new JLabel("Đơn vị: "+donvi);
        lbldonvi.setBounds(5,75,240,30);
        txtmota = new JTextPane();
        txtmota.setText("Mô tả: "+mota);
        txtmota.setEditable(false);
        txtmota.setBounds(0,110,240,70);
        txtmota.setBackground(Color.white);
        lblimg = new JLabel(new ImageIcon(ImageIO.read(new File(img_path))));
        lblimg.setBounds(350,0,200,230);
        

        
        panel.add(lblmasp);
        panel.add(lbltensp);
        panel.add(lbldonvi);
        panel.add(txtmota);
        panel.add(lblimg);


        
        pnlproductinfo.add(panel);
        pnlproductinfo.repaint();
        pnlproductinfo.validate();
    }
    public ProductUI() throws IOException{
        initcomponent();
    }
    
    public String getNamepage() {

        return Namepage;
        }
    
}
