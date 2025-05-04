/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import GUI.MemberGUI.MemberUI;
import GUI.EmployeeGUI.EmployeeUI;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.ui.FlatLineBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.MatteBorder;

/**
 *
 * @author NAME
 */
public class Workspace extends JFrame implements MouseListener {

    JPanel currentpanel = new JPanel(new BorderLayout());
    JPanel[] items = new JPanel[10];
    ArrayList<JPanel> panel = new ArrayList<>();
    JLabel[] lblitems = new JLabel[10];
    ArrayList<String> items_tag = new ArrayList<>();
    Color text_clr = new Color(151, 152, 157);
    Color hover_clr = new Color(2, 68, 94);
    Color bg_color = new Color(33, 38, 60);
    int currentpage = 0;
    private void initcomponent() throws IOException {
        this.setSize(new Dimension(1600, 950));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setResizable(false);
        
        Dashboard dashboard = new Dashboard();
        this.items_tag.add( dashboard.getNamepage());
        this.panel.add(dashboard);
        
        Statistics report = new Statistics(this);
        this.items_tag.add(report.getNamepage());
        this.panel.add(report);
        
        CheckOut checkout = new CheckOut();
        this.items_tag.add(checkout.getNamepage());
        this.panel.add(checkout);
        
        ProductUI product = new ProductUI();
        this.items_tag.add(product.getNamepage());
        this.panel.add(product);
        
        EmployeeUI nhanvien = new EmployeeUI(this);
        this.items_tag.add(nhanvien.getNamepage());
        this.panel.add(nhanvien);
        
        MemberUI customer = new MemberUI(this);
        this.items_tag.add(customer.getNamepage());
        this.panel.add(customer);
        
        JPanel nav_bar = Navigater();

        currentpanel.add(dashboard,BorderLayout.CENTER);
        this.add(nav_bar, BorderLayout.WEST);
        this.add(currentpanel, BorderLayout.CENTER);

        this.setVisible(true);
        
    }

    public JPanel Navigater() {
        JPanel nav_bar = new JPanel(null);
        nav_bar.setBorder(new MatteBorder(0, 0, 0, 2, Color.DARK_GRAY));
        Font text_font = new Font("", Font.CENTER_BASELINE, 16);
        nav_bar.setPreferredSize(new Dimension(200, 0));
        nav_bar.setBackground(bg_color);
        Insets ins = new Insets(5,40,5,00);
        for (int i=0 ; i<this.items_tag.size();i++) {
            this.items[i] = new JPanel(null);
            this.items[i].setBackground(bg_color);
            this.items[i].setBounds(0, i * 56, 200, 55);
            this.lblitems[i] = new JLabel(items_tag.get(i), SwingConstants.LEFT);
            this.lblitems[i].setBorder(new FlatLineBorder(ins,null,0,0));
            this.lblitems[i].setForeground(text_clr);
            this.lblitems[i].setFont(text_font);
            this.lblitems[i].setBounds(0, 0, 200, 55);
            this.items[i].add(lblitems[i]);
            this.items[i].addMouseListener(this);
            nav_bar.add(this.items[i]);
        }
        this.lblitems[0].setForeground(text_clr);
        this.lblitems[0].setForeground(Color.white);
        
        

        return nav_bar;
    }

    public void switchpanel(int index) {
        this.remove(currentpanel);
        currentpanel = panel.get(index);
        this.add(currentpanel, BorderLayout.CENTER);
        this.repaint();
        this.validate();

    }

    public Workspace() throws IOException {
        initcomponent();
    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException, IOException {
        UIManager.setLookAndFeel(new FlatIntelliJLaf());
        
        Workspace workspace = new Workspace();

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        for(int i =0;i<lblitems.length;i++){
            if (e.getSource() == items[i]) {
            lblitems[currentpage].setForeground(text_clr);
            currentpage = i;
            lblitems[currentpage].setForeground(Color.white);
            switchpanel(i);
            break;
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
        for(int i =0;i<lblitems.length;i++){
            if (e.getSource() == items[i]) {
            items[i].setBackground(hover_clr);
            break;
        }
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        for(int i =0;i<lblitems.length;i++){
            if (e.getSource() == items[i]) {
            items[i].setBackground(bg_color);
            break;
        }
        }
    }

}
