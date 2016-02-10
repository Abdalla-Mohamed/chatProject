/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framepackage;

import java.awt.Color;
import java.awt.Component;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.io.Serializable;

/**
 *
 * @author Abdalla
 */
public class CirclePart extends Component implements Serializable {

    public CirclePart() {
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
      //  graphics2D.setRenderingHint(RenderingHints.KEY_RENDERING, this);

        graphics2D.setColor(Color.red);
        GradientPaint gp4 = new GradientPaint(10, 15,
                Color.PINK, 15, 25, Color.cyan.brighter(), false);
        
        graphics2D.setPaint(gp4);
        graphics2D.fillOval(0, 0, super.getWidth(), super.getHeight());
    }

    @Override
    public void repaint() {
        super.repaint(); //To change body of generated methods, choose Tools | Templates.
    }

}
