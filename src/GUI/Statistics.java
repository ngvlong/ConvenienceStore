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
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import java.util.regex.Matcher;
import javax.swing.JOptionPane;
import sharedComponents.TextField;

/**
 *
 * @author NAME
 */
public class Statistics extends JPanel implements MouseListener{
    String namepage = "Báo Cáo";
    Insets inset10 = new Insets(5,10,10,10);
    DefaultTableModel model1,model2;
    JTable table;
    JPanel panel1,panel2,panel3,panel4,heading_ct_panel ;
    JButton add,detail,delete,switchaddpanel;
    Color blue = new Color(33, 150, 243);
    Color red = new Color(229, 57, 53);
    JDialog dialog;
    JFrame frame;
    String today;
    SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
    Date date = Calendar.getInstance().getTime();
    Font font20 = new Font("Roboto",Font.CENTER_BASELINE,20);
    Font font18 = new Font("Roboto",Font.CENTER_BASELINE,18);
    Object[] viewcolumn = {"Mã phiếu","Người tạo","Ngày tạo","Mục đích","Nội dung"};
    Object[] statictiscolumn = {"Mã sản phẩm","Tên sản phẩm","Đơn giá","Số lượng tồn","Thực tồn","Chênh lệch","Nguyên nhân"};
    Object[][] statisticdata = {{"1","hi","12","13"},{"1","hi","12","13"},{"1","hi","12","13"}};
    Object[][] data = {{"KK0204241","VTH","02-04-2024","Kiểm kê định kì","Kiểm kê hàng tồn"},{"KK0204241","VTH","02-04-2024","Kiểm kê định kì","Kiểm kê hàng tồn"}};
    public void initcompnent(JFrame frame){
        this.setLayout(new BorderLayout());
        this.setBorder(new FlatLineBorder(inset10,null,0,0));
        this.frame = frame;
        this.today = dt.format(date).toString();
        panel1 = new JPanel(new BorderLayout(10,5));
        panel1.setBorder(new FlatLineBorder(inset10,null,0,40));
        panel1.setBackground(Color.white);
        panel2 = new JPanel(new BorderLayout());
        panel2.setBackground(Color.white);
        panel2.setBorder(new EmptyBorder(5,20,5,40));
        panel2.setPreferredSize(new Dimension(0,50));
        switchaddpanel = new JButton("Tạo phiếu kiểm kê");
        switchaddpanel.setFont(new Font("Roboto",Font.CENTER_BASELINE,14));
        switchaddpanel.setForeground(Color.white);
        switchaddpanel.setBackground(blue);
        switchaddpanel.addMouseListener(this);
        panel2.add(switchaddpanel,BorderLayout.EAST);
        JLabel heading = new JLabel("Kiểm kê");
        heading.setFont(new Font("Roboto",Font.CENTER_BASELINE,22));
        panel2.add(heading,BorderLayout.WEST);
        
        heading_ct_panel = new JPanel(null);
        heading_ct_panel.setBackground(Color.white);   
        TextField tfdate = new TextField(200, 40, "Ngày", font18, false,this.today , font18, 05);
        tfdate.setLocation(100,0);
        heading_ct_panel.add(tfdate);
        heading_ct_panel.setVisible(false);
        panel2.add(heading_ct_panel,BorderLayout.CENTER);
        
        panel3 = Table();
        
        panel4 = new JPanel(new BorderLayout());
        panel4.setBackground(Color.white);
        panel4.setBorder(new FlatLineBorder(new Insets(10,10,5,10),null,1,40));
        panel4.setPreferredSize(new Dimension(0,50));
        panel4.setVisible(false);
        JButton apply = new JButton("Xác nhận");
        apply.setBackground(blue);
        apply.setForeground(Color.white);
        apply.setFont(font20);
        panel4.add(apply,BorderLayout.EAST);
        
        panel1.add(panel3,BorderLayout.CENTER);
        panel1.add(panel2,BorderLayout.NORTH);
        panel1.add(panel4,BorderLayout.SOUTH);
        
        this.add(panel1,BorderLayout.CENTER);
        
    }
    
    public JPanel Table(){
        JPanel panel = new JPanel(new BorderLayout());
        
        model1 = new DefaultTableModel(){
            // Đảm bảo ô được chỉ định không thể chỉnh sửa
            @Override
            public boolean isCellEditable(int row, int column) {
                    return false;
            }
        };
        
        model2 = new DefaultTableModel(){
            // Đảm bảo ô được chỉ định không thể chỉnh sửa
            @Override
            public boolean isCellEditable(int row, int column) {
                    if(column==4 || column==6)
                        return true; // Trả về false để ngăn chặn chỉnh sửa
                    else
                        return false;
            }
        };
        table = new JTable();
        model2.addTableModelListener(new TableModelListener() {
             @Override
             public void tableChanged(TableModelEvent e) {
                 // In ra dữ liệu mới sau mỗi lần thay đổi
                if(e.getColumn()==4){
                    int selectedRow = table.getSelectedRow();
                    String input =table.getValueAt(selectedRow, 4).toString();
                    System.out.println(input);
                    int store = Integer.parseInt((String)table.getValueAt(selectedRow, 3));
                    if(input.matches( "^[0-9]+$"))
                        table.setValueAt(store-Integer.parseInt(input), selectedRow, 5);
                    else
                        if(!input.isEmpty())
                            JOptionPane.showMessageDialog(null, "Nhập sai định dạng");
                }
             }
         });
        model1.setColumnIdentifiers(viewcolumn);
        setData(data, model1);
        model2.setColumnIdentifiers(statictiscolumn);
        setData(statisticdata, model2);
        table.setModel(model1);
        table.setFocusable(false);
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                int index = table.getSelectedRow();
                if(e.getClickCount()>1 && table.getSelectedColumn()!=0){
                    showActionPanel(e.getPoint(), e.getLocationOnScreen());
                }
            }
        });
        JScrollPane scrpnl = new JScrollPane(table);
        
        panel.add(scrpnl,BorderLayout.CENTER);
        
        return panel;
    }
    
    public void showActionPanel(Point tablepoint,Point mousepoint){
        int row = table.rowAtPoint(tablepoint);
        String id = (String) table.getValueAt(row, 0);
        showDialogAtMousePosition(id, mousepoint);
    }
    
    private void showDialogAtMousePosition(String id, Point mousePosition) {
        dialog = new JDialog(frame,"Actions",true);
        dialog.setLayout(new BorderLayout());
        dialog.setPreferredSize(new Dimension(150,200));
        
        JPanel panel1 = new JPanel(new FlowLayout());
        panel1.setPreferredSize(new Dimension(0,30));

        JLabel idLabel = new JLabel("ID: " + id);

        panel1.add(idLabel);
        
        JPanel panel2 = new JPanel(new GridLayout(3,0,0,0));
        panel2.setBorder(new FlatLineBorder(new Insets(10,20,10,20), null,0,0));
        
        detail = new JButton("Chi tiết");
        detail.addMouseListener(this); 
        
        delete = new JButton("Xóa");
        delete.setBackground(Color.white);
        delete.setForeground(red);
        delete.addMouseListener(this);
        
        panel2.add(detail);
        panel2.add(delete);
        
        dialog.add(panel1,BorderLayout.NORTH);
        dialog.add(panel2,BorderLayout.CENTER);

        // Set location of the dialog based on mouse position
        dialog.setLocation(mousePosition);

        dialog.pack();
        dialog.setVisible(true);
    }
    
    public void switchpanel(){
        if(switchaddpanel.getBackground()==blue)
            table.setModel(model2);
        else table.setModel(model1);
    }
    
    public void setData(Object[][] data,DefaultTableModel model){
        model.setRowCount(0);
        for(int i =0;i<data.length;i++){
            model.addRow(data[i]);
        }
    }
    
    public Statistics(JFrame frame){
        initcompnent(frame);
    } 
    
    public String getNamepage(){
        return this.namepage;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource()==switchaddpanel && switchaddpanel.getBackground()==blue) {
            switchpanel();
            switchaddpanel.setText("Go back");
            switchaddpanel.setBackground(Color.white);
            switchaddpanel.setForeground(Color.black);
            heading_ct_panel.setVisible(true);
            panel4.setVisible(true);
        }
        else{
            switchpanel();
            switchaddpanel.setText("Tạo phiếu kiểm kê");
            switchaddpanel.setBackground(blue);
            switchaddpanel.setForeground(Color.white);
            heading_ct_panel.setVisible(false);
            panel4.setVisible(false);
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
