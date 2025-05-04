/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sharedComponents;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author NAME
 */
public class CheckBox extends JPanel{
    
    JLabel title;
    JCheckBox[] cbitems;
    
    public void init(int width,int height,String title,Font titlefont,Boolean editable,String[] items,Font items_font,int spacing){
        int counter = items.length;
        ButtonGroup grp = new ButtonGroup();
        JPanel checkboxpnl = new JPanel(new GridLayout(0, counter));
        checkboxpnl.setBackground(Color.white);
        this.setSize(new Dimension(width, height));
        this.setLayout(new BorderLayout(spacing,0));
        this.setBackground(Color.white);
        this.title = new JLabel();
        this.title.setText(title);
        this.title.setFont(titlefont);        
        cbitems = new JCheckBox[counter];
        
        for(int i=0;i<items.length;i++){
            cbitems[i] = new JCheckBox(items[i]);
            cbitems[i].setFont(items_font);
            cbitems[i].setEnabled(editable);
            grp.add(cbitems[i]);
            checkboxpnl.add(cbitems[i]);
        }
        
        this.add(this.title,BorderLayout.WEST);
        this.add(checkboxpnl,BorderLayout.CENTER);
        
    }
    
    public CheckBox(int width,int height,String title,Font titlefont,Boolean editable,String[] items,Font items_font,int spacing){
        init(width,height,title,titlefont,editable,items,items_font,spacing);
    }
    
    public JCheckBox getOption(int index){
        return cbitems[index];
    }
    
}
