/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sharedComponents;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author NAME
 */
public class GradientPanel extends JPanel {
    Color color1,color2;
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();


        // Get the width and height of the panel
        int width = getWidth();
        int height = getHeight();

        // Create a gradient paint object
        GradientPaint gradientPaint = new GradientPaint(0, 0, color1, width, 0, color2);

        // Set the paint to the Graphics2D object
        g2d.setPaint(gradientPaint);

        // Fill the entire panel with the gradient
        g2d.fillRect(0, 0, width, height);

        // Dispose the Graphics2D object
        g2d.dispose();
    }

    public GradientPanel() {
    }
    
    public GradientPanel(Color color1,Color color2) {
        this.color1 = color1;
        this.color2 = color2;
    }
    
    
}