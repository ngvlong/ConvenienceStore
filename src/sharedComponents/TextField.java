/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sharedComponents;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author NAME
 */
public class TextField extends JPanel{
    JLabel title;
    JTextField inputfield;
    
    public void init(int width,int height,String title,Font titlefont,boolean editable,String placeholder,Font inputfont,int spacing){
        this.setSize(new Dimension(width, height));
        this.setLayout(new BorderLayout(spacing,0));
        this.setBackground(Color.white);
        this.title = new JLabel();
        this.title.setText(title);
        this.title.setFont(titlefont);
        this.inputfield = new JTextField();
        this.inputfield.setBackground(Color.white);
        this.inputfield.setEditable(editable);
        this.inputfield.setFont(inputfont);
//        if(editable)
            this.inputfield.putClientProperty("JTextField.placeholderText", placeholder);
//        else
//            this.inputfield.setText("Not found");
        this.add(this.title,BorderLayout.WEST);
        this.add(inputfield,BorderLayout.CENTER);
        
    }
    
    public TextField (int width,int height,String title,Font titlefont,boolean editable,String placeholder,Font inputfont,int spacing){
        init(width,height,title,titlefont,editable,placeholder,inputfont,spacing);
    }

    public void setTitle(JLabel title) {
        this.title = title;
    }

    public void setInputfield(JTextField inputfield) {
        this.inputfield = inputfield;
    }

    public JLabel getTitle() {
        return title;
    }

    public JTextField getInputfield() {
        return inputfield;
    }
    
    public String getText(){
        return inputfield.getText();
    }
    
}
