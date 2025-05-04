/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import CurveLineChart.raven.panel.PanelShadow;
import CurveLineChart.raven.raven.chart.CurveLineChart;
import BarChart.chart.Chart;
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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NAME
 */
public class Dashboard extends JPanel implements MouseListener,Runnable {

    Color bg_clr = new Color(33, 38, 60);
    String namepage = "Dashboard";
    JTextField txtsearch = new JTextField();
    JButton btnsearch = new JButton(new ImageIcon(ImageIO.read(new File("src\\Image\\Search.png"))));
    CurveLineChart linechart = new CurveLineChart();
    JTable tbl = new JTable() {
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    ;
    };
    Chart barchart = new Chart();
    JPanel pnlslkhach,pnlslnhanvien,pnldoanhthu,pnlstorecode,pnlclock;
    JLabel lblnhanvien = new JLabel("13812", new ImageIcon(ImageIO.read(new File("src\\Image\\Manager.png"))), JLabel.CENTER);
    JLabel lblkhach = new JLabel("13812", new ImageIcon(ImageIO.read(new File("src\\Image\\Businessman.png"))), JLabel.CENTER);
    JLabel lbldoanhthu = new JLabel("13812", new ImageIcon(ImageIO.read(new File("src\\Image\\Dollar.png"))), JLabel.CENTER);
    JLabel storecode,lbltime,lbldate;
    String[] month = {"1", "2", "3", "4", "5", "6"};
    int[] doanhthu = {12, 14, 15, 16, 17, 18};
    int[] loinhuan = {12, 14, 15, 16, 17, 18};
    int[] sodon = {12, 14, 15, 16, 17, 18};
    
    
    public void initcomponent() throws IOException {
        this.setLayout(null);

        //--Over view--
        JPanel panel = OverviewPanel();
        
        //--Line chart---
        PanelShadow panel1 = LineChartPanel();

        //--Table---
        PanelShadow panel2 = TablePanel();

        //--Column Chart---
        PanelShadow panel3 = BarchartPanel();

        this.add(panel);
        this.add(panel1);
        this.add(panel2);
        this.add(panel3);
    }

    public JPanel OverviewPanel() throws IOException{
        JPanel panel = new JPanel(null);
        panel.setBounds(15,10,1355,115);
        
        pnlslkhach = new JPanel(null);
        pnlslkhach.setBounds(0,5,220,105);
        pnlslkhach.setBackground(new Color(0, 172, 193));
        pnlslkhach.setBorder(new FlatLineBorder(new Insets(16, 16, 16, 16), new Color(41, 74, 125), 0, 40));
        
        lblkhach.setForeground(Color.white);
        lblkhach.setBounds(10,15,200,75);
        lblkhach.setFont(new Font("",Font.CENTER_BASELINE,26));
        pnlslkhach.add(lblkhach);
        
        pnlslnhanvien = new JPanel(null);
        pnlslnhanvien.setBounds(240,5,220,105);
        pnlslnhanvien.setBackground(new Color(30, 133, 222));
        pnlslnhanvien.setBorder(new FlatLineBorder(new Insets(16, 16, 16, 16), new Color(41, 74, 125), 0, 40));
        
        lblnhanvien.setForeground(Color.white);
        lblnhanvien.setBounds(10,15,200,75);
        lblnhanvien.setFont(new Font("",Font.CENTER_BASELINE,26));
        pnlslnhanvien.add(lblnhanvien);
        
        pnldoanhthu= new JPanel();
        pnldoanhthu.setBounds(480,5,220,105);
        pnldoanhthu.setBackground(new Color(43,141,87));
        pnldoanhthu.setBorder(new FlatLineBorder(new Insets(16, 16, 16, 16), Color.white, 0, 40));
        
        lbldoanhthu.setForeground(Color.white);
        lbldoanhthu.setBounds(10,15,200,75);
        lbldoanhthu.setFont(new Font("",Font.CENTER_BASELINE,26));
        pnldoanhthu.add(lbldoanhthu);
        
        pnlstorecode= new JPanel(null);
        pnlstorecode.setBounds(800,5,220,105);
        pnlstorecode.setBorder(new FlatLineBorder(new Insets(16, 16, 16, 16), new Color(30, 133, 222), 5, 40));
        
        storecode = new JLabel("NVC-6324");
        storecode.setFont(new Font("",Font.CENTER_BASELINE,22));
        storecode.setBounds(60,5,150,95);
        pnlstorecode.add(storecode);
        
        pnlclock = new JPanel(null);
        pnlclock.setBounds(1040,5,310,105);
        pnlclock.setBackground(new Color(0,102,204));
        pnlclock.setBorder(new FlatLineBorder(new Insets(16, 16, 16, 16), new Color(30, 133, 222), 0, 40));
        
        lbltime=new JLabel();
        lbltime.setBounds(85,15,150,45);
        lbltime.setForeground(Color.white);
        lbltime.setFont(new Font("",Font.BOLD,24));
        
        lbldate=new JLabel();
        lbldate.setBounds(90,45,120,45);
        lbldate.setForeground(Color.white);
        lbldate.setFont(new Font("",Font.LAYOUT_RIGHT_TO_LEFT,24));
        
        Thread t = new Thread(this);
        t.start();
        
        pnlclock.add(lbltime);
        pnlclock.add(lbldate);
        
        
        panel.add(pnlslkhach);
        panel.add(pnlslnhanvien);
        panel.add(pnldoanhthu);
        panel.add(pnlstorecode);
        panel.add(pnlclock);
        
        return panel;
    }
    
    public PanelShadow LineChartPanel() {
        PanelShadow panel = new PanelShadow();
        panel.setLayout(new BorderLayout());
        panel.setBounds(10, 130, 1365, 320);
        panel.setBorder(new FlatLineBorder(new Insets(16, 16, 16, 16), null, 0, 0));
        linechart.setTitle("Tổng quan");
        linechart.addLegend("Doanh thu", Color.decode("#7b4397"), Color.decode("#dc2430"));
        linechart.addLegend("Lợi nhuận", Color.decode("#e65c00"), Color.decode("#F9D423"));
        linechart.addLegend("Số đơn", Color.decode("#0099F7"), Color.decode("#F11712"));
        linechart.setForeground(Color.black);

        linechart.setLineChartData(month, doanhthu, loinhuan,sodon);

        panel.add(linechart, BorderLayout.CENTER);
        return panel;
    }

    public PanelShadow TablePanel() throws IOException {
        tbl.setFocusable(false);
        
        PanelShadow panel = new PanelShadow();
        panel.setLayout(new BorderLayout());
        panel.setBounds(10, 450, 750, 455);
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        //--search--
        JPanel pnlsearch = new JPanel(null);
        pnlsearch.setPreferredSize(new Dimension(0, 60));
        pnlsearch.setBackground(Color.white);

        JLabel lblpaneltitle = new JLabel("Doanh thu");
        lblpaneltitle.setFont(new Font("", Font.BOLD, 18));
        lblpaneltitle.setBounds(30, 10, 300, 40);

        txtsearch.putClientProperty("JTextField.placeholderText", "Tìm kiếm");
        txtsearch.setBounds(420, 10, 250, 40);
      
        btnsearch.setBounds(670, 10, 40, 40);
        btnsearch.setForeground(Color.BLUE);

        pnlsearch.add(lblpaneltitle);
        pnlsearch.add(txtsearch);
        pnlsearch.add(btnsearch);

        setTableData();

        JScrollPane pnltbl = new JScrollPane(tbl);
        UIManager.put("ScrollPane.smoothScrolling", true);
        pnltbl.setBackground(bg_clr);

        panel.add(pnlsearch, BorderLayout.NORTH);
        panel.add(pnltbl, BorderLayout.CENTER);
        return panel;
    }

    public PanelShadow BarchartPanel(){
        PanelShadow panel = new PanelShadow();
        panel.setLayout(new BorderLayout());
        panel.setBounds(760, 450, 615, 455);
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        panel.setBackground(bg_clr);

        JPanel pnlbarchartTitle = new JPanel(null);
        pnlbarchartTitle.setPreferredSize(new Dimension(0, 60));
        pnlbarchartTitle.setBackground(Color.white);

        JLabel lbbarcharttitle = new JLabel("Số đơn trong ngày");
        lbbarcharttitle.setFont(new Font("", Font.CENTER_BASELINE, 18));
        lbbarcharttitle.setBounds(30, 10, 200, 40);

        pnlbarchartTitle.add(lbbarcharttitle);

        barchart.addLegend("Income", new Color(245, 189, 135));
        barchart.addLegend("Expense", new Color(135, 189, 245));
        barchart.addLegend("Profit", new Color(189, 135, 245));

        double[][] dt = {{12, 14, 15}, {12, 14, 15}, {12, 14, 15}, {12, 14, 15}, {12, 14, 15}, {12, 14, 15}, {12, 14, 15}, {12, 14, 15}};
        String[] timeline = {"0-2","3-5","6-8","9-11","11-13","14-16","17-19","20-23"};
        barchart.setBarCharData(timeline, dt);

        panel.add(pnlbarchartTitle, BorderLayout.NORTH);
        panel.add(barchart, BorderLayout.CENTER);
        return panel;
    }
    
    public void setTableData() {
        String[] columnNames = {"Ngày",
            "Doanh thu",
            "Lợi nhuận",
            };

        Object[][] dt = {
            {"Kathy", "Smith",
                "Snowboarding"},
            {"John", "Doe",
                "Rowing" },
            {"Sue", "Black",
                "Knitting" },
            {"Jane", "White",
                "Speed reading"},
            {"Joe", "Brown",
                "Pool"},
            {"Kathy", "Smith",
                "Snowboarding"},
            {"John", "Doe",
                "Rowing" },
            {"Sue", "Black",
                "Knitting" },
            {"Jane", "White",
                "Speed reading"},
            {"Joe", "Brown",
                "Pool"},
            {"Kathy", "Smith",
                "Snowboarding"},
            {"John", "Doe",
                "Rowing" },
            {"Sue", "Black",
                "Knitting" },
            {"Jane", "White",
                "Speed reading" },
            {"Joe", "Brown",
                "Pool" },
            {"Kathy", "Smith",
                "Snowboarding" },
            {"John", "Doe",
                "Rowing" },
            {"Sue", "Black",
                "Knitting" },
            {"Jane", "White",
                "Speed reading" },
            {"Joe", "Brown",
                "Pool" },
            {"Kathy", "Smith",
                "Snowboarding" },
            {"John", "Doe",
                "Rowing" },
            {"Sue", "Black",
                "Knitting" },
            {"Jane", "White",
                "Speed reading" },
            {"Joe", "Brown",
                "Pool" },
            {"Kathy", "Smith",
                "Snowboarding" },
            {"John", "Doe",
                "Rowing" },
            {"Sue", "Black",
                "Knitting" },
            {"Jane", "White",
                "Speed reading" },
            {"Joe", "Brown",
                "Pool" }
        };

        DefaultTableModel tblmodel = new DefaultTableModel();

        tbl.setModel(tblmodel);

    }

    public String getNamepage() {
        return namepage;
    }

    

    public Dashboard() throws IOException {
        initcomponent();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
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

    @Override
    public void run() {
        while(true){
            Calendar cal = Calendar.getInstance();
            
            Date date = cal.getTime();
                        
            SimpleDateFormat sdf12 = new SimpleDateFormat("HH:mm:ss aa");
            
            SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
            
            lbltime.setText(sdf12.format(date));
            
            lbldate.setText(dt.format(date));
        }
    }

}
