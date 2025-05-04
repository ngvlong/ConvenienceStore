/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sharedComponents;

import com.toedter.calendar.JDateChooser;
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
public class DateChooser extends JPanel{
    JLabel title;
    JDateChooser date;
    
    public void init(int width,int height,String title,Font titlefont,Boolean editable,Font dateFont,int spacing){
        this.setSize(new Dimension(width, height));
        this.setLayout(new BorderLayout(spacing,0));
        this.setBackground(Color.white);
        this.title = new JLabel();
        this.title.setText(title);
        this.title.setFont(titlefont);
        date = new JDateChooser();
        date.setFont(titlefont);
        date.setBackground(Color.white);
        date.setEnabled(editable);
        this.add(this.title,BorderLayout.WEST);
        this.add(date,BorderLayout.CENTER);
        
    }
    
    public DateChooser (int width,int height,String title,Font titlefont,Boolean editable,Font datefont,int spacing){
        init(width,height,title,titlefont,editable,datefont,spacing);
    }

    public void setTitle(JLabel title) {
        this.title = title;
    }

    public void setDate(JDateChooser date) {
        this.date = date;
    }

    public JDateChooser getDate() {
        return date;
    }
    
    public String getText(){
        return date.getDateFormatString();
    }
    

    public JLabel getTitle() {
        return title;
    }

}
