/**
 * Write a description of class LoopDrawing here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class DrawingPicture extends JComponent
{
    public void paintComponent(Graphics g){

        Graphics2D g2 = (Graphics2D)g;

	      //Define widths and colors
        BasicStroke thick = new BasicStroke(40.0f);
        Color chiRed = new Color(206, 17, 45);
        Color chiBlue = new Color(85, 193, 232);

        //Define all my objects
        Ellipse2D.Double logoRing = new Ellipse2D.Double(120, 120, 280, 280);
        int[] xPoints = new int[] {260, 277, 347, 293, 347, 277, 260, 243, 173, 227, 173, 243}; //define x coords for polygon
        int[] yPoints = new int[] {160, 227, 210, 260, 310, 293, 360, 293, 310, 260, 210, 227}; //define y cords for polygon
        Polygon star = new Polygon(xPoints, yPoints, 12);
        Rectangle topStripe1 = new Rectangle(0, 20, 500, 20);
        Rectangle topStripe2 = new Rectangle(0, 40, 500, 20);
        Rectangle bottomStripe1 = new Rectangle(0, 460, 500, 20);
        Rectangle bottomStripe2 = new Rectangle(0, 480, 500, 20);

        //Draw all of the elements
        //Draw white background
        g2.setColor(Color.white);
        g2.fillRect(0,0,520,520);
        //Draw red ones
        g2.setColor(chiRed);
        g2.fill(star);
        g2.fill(topStripe2);
        g2.fill(bottomStripe1);
        //Draw blue ones
        g2.setColor(chiBlue);
        g2.setStroke(thick);
        g2.draw(logoRing);
        g2.fill(topStripe1);
        g2.fill(bottomStripe2);
    }
    public void drawGrid(Graphics g2){
        g2.setColor(new Color(211, 211, 211));

        // Draw vertical lines
        for(int x = 0; x < 1000; x += 20){
            g2.drawLine(x, 0, x, 1000);
            g2.drawString("" + x, x, 10);
        }

        // Draw horizontal lines
        for(int y = 20; y < 1000; y += 20){
            g2.drawLine(0, y, 1000, y);
            g2.drawString("" + y, 0, y);
        }
    }
}
