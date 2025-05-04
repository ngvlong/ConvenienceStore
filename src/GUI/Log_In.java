/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.ui.FlatLineBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import KentHipos.Kensoft;
import java.awt.BorderLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import sharedComponents.GradientPanel;
/**
 *
 * @author NAME
 */
public class Log_In extends JFrame implements MouseListener{
    
    JPanel panel1,panel2,panel3,background_panel;
    JLabel lblsignup,background;
    Dimension dm = new Dimension(1100,600);
    Kensoft animate = new Kensoft();
    JTextField username_signup,password_signup,repassword_signup,username,password;
    JButton btnlogin,btncreate;
    public void initcomponent() throws IOException{
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(dm);
        this.setLocationRelativeTo(null);
        this.setBackground(Color.white);
        
        panel1 = new GradientPanel(new Color(24, 83, 223),new Color(58, 141, 233));
        panel1.setLayout(null);
        panel1.setBorder(new FlatLineBorder(new Insets(0,0,0,0), null,0,40));
//        panel1.setPreferredSize(new Dimension(500,562));
        panel1.setBounds(-5,0,610,562);
        
        background_panel = new JPanel(new BorderLayout());
        background_panel.setBounds(0,0,610,400);
        
        ImageIcon img = new ImageIcon(ImageIO.read(new File("src\\Image\\Login_bgr.jpg")));
        Image scale = img.getImage().getScaledInstance(610,400, Image.SCALE_SMOOTH);
        img = new ImageIcon(scale);
        
        background = new JLabel(img);
        
        background_panel.add(background,BorderLayout.CENTER);
        
        lblsignup = new JLabel("Forgot password");
        lblsignup.setForeground(Color.white);
        lblsignup.setFont(new Font("Roboto",Font.CENTER_BASELINE,24));
        lblsignup.setHorizontalAlignment(JLabel.CENTER);
        lblsignup.setBounds(230,460,200,40);
        lblsignup.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(panel1.getX()==-5){
                    animate.jPanelXRight(-5, 475, 1, 10, panel1);
                    animate.jPanelXRight(620, 1100, 1, 5, panel2);
                    animate.jPanelXRight(-450, 15, 1, 10, panel3);
                    lblsignup.setText("Sign In");
                }
                else{
                    animate.jPanelXLeft(475, -5, 1, 10, panel1);
                    animate.jPanelXLeft(1100, 620, 1, 10, panel2);
                    animate.jPanelXLeft(15, -450, 1, 5, panel3);
                    lblsignup.setText("Forgot password");
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
        });
        panel1.add(lblsignup);
        panel1.add(background_panel);
        panel2 = LoginForm();
        panel3 = ForgotForm();
        
        this.add(panel1);
        this.add(panel2);
        this.add(panel3);
        
        this.setVisible(true);
    }
    
    public JPanel ForgotForm(){
        JPanel panel = new JPanel(null);
        panel.setBackground(Color.white);
        panel.setBorder(new FlatLineBorder(new Insets(0,0,0,0), null,0,40));
        panel.setBounds(-450,10,450,540);
        
        JLabel title = new JLabel("Forgot Password");
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(new Font("", Font.CENTER_BASELINE, 30));
        title.setForeground(Color.black);
        title.setBounds(110, 70, 260, 50);

        Font inputfont = new Font("", Font.CENTER_BASELINE, 16);
        
        username_signup = new JTextField();
        username_signup.setBounds(90, 190, 300, 40);
        username_signup.putClientProperty("JTextField.placeholderText", "Username");
        username_signup.setFont(inputfont);

        password_signup = new JTextField();
        password_signup.setBounds(90, 260, 300, 40);
        password_signup.putClientProperty("JTextField.placeholderText", "Password");
        password_signup.setFont(inputfont);
        
        repassword_signup = new JTextField();
        repassword_signup.setBounds(90, 330, 300, 40);
        repassword_signup.putClientProperty("JTextField.placeholderText", "Confirm password");
        repassword_signup.setFont(inputfont);

        btncreate = new JButton("Confirm");
        btncreate.setBackground(new Color(0,128,255));
        btncreate.setForeground(Color.white);
        btncreate.setFont(new Font("", Font.CENTER_BASELINE, 18));
        btncreate.setBounds(90, 410, 300, 40);
        
        panel.add(title);
        panel.add(username_signup);
        panel.add(password_signup);
        panel.add(repassword_signup);
        panel.add(btncreate);
        
        return panel;
    }
    
    public JPanel LoginForm(){
        JPanel login_form = new JPanel(null);
        login_form.setBackground(Color.white);
        login_form.setBounds(620,10,450,540);
        login_form.setBorder(new FlatLineBorder(new Insets(10,10,10,10),null,0,40));
        
        JLabel title = new JLabel("Sign In");
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(new Font("", Font.CENTER_BASELINE, 35));
        title.setForeground(Color.black);
        title.setBounds(180, 70, 120, 50);

        Font inputfont = new Font("", Font.CENTER_BASELINE, 16);
        
        username = new JTextField();
        username.setBounds(90, 190, 300, 40);
        username.putClientProperty("JTextField.placeholderText", "Username");
        username.setFont(inputfont);

        password = new JTextField();
        password.setBounds(90, 260, 300, 40);
        password.putClientProperty("JTextField.placeholderText", "Password");
        password.setFont(inputfont);

        btnlogin = new JButton("Login");
        btnlogin.setBackground(new Color(0,128,255));
        btnlogin.setForeground(Color.white);
        btnlogin.setFont(new Font("", Font.CENTER_BASELINE, 18));
        btnlogin.setBounds(90, 340, 300, 40);
        
        login_form.add(title);
        login_form.add(username);
        login_form.add(password);
        login_form.add(btnlogin);
        
        return login_form;
    }

    public Log_In() throws IOException {
        initcomponent();
    }    
    
    public static void main(String[] args) throws UnsupportedLookAndFeelException, IOException {
        UIManager.setLookAndFeel(new FlatIntelliJLaf());
        UIManager.put("Table.showVerticalLines", false);
        UIManager.put("Table.showHorizontalLines", true);
        UIManager.put("TextComponent.arc", 5);
        UIManager.put("ScrollBar.thumbArc", 999);
        UIManager.put("ScrollBar.thumbInsets", new Insets(2, 2, 2, 2));
        UIManager.put("Button.iconTextGap", 10);
        UIManager.put("PasswordField.showRevealButton", true);
        UIManager.put("Table.selectionBackground", new Color(240, 247, 250));
        UIManager.put("Table.selectionForeground", new Color(0, 0, 0));
        UIManager.put("Table.scrollPaneBorder", new EmptyBorder(0, 0, 0, 0));
        UIManager.put("Table.rowHeight", 40);
        UIManager.put("TabbedPane.selectedBackground", Color.white);
        UIManager.put("TableHeader.height", 40);
        UIManager.put("TableHeader.font", UIManager.getFont("h4.font"));
        UIManager.put("TableHeader.background", new Color(242, 242, 242));
        UIManager.put("TableHeader.separatorColor", new Color(242, 242, 242));
        UIManager.put("TableHeader.bottomSeparatorColor", new Color(242, 242, 242));
        UIManager.put("Panel.border", 8);
        Log_In login = new Log_In();
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
    
}
