/**
 * Write a description of class LoopDrawing here.
 *
 * @author Matthew Poelster
 * @version 1.0.0
 */

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class DrawingPicture extends JComponent {
    public void paintComponent(Graphics g) {

        //Create graphics object
        Graphics2D g2 = (Graphics2D)g;

	      //Define widths and colors
        BasicStroke thick = new BasicStroke(40.0f);
        BasicStroke thin = new BasicStroke(5.0f);
        Color chiRed = new Color(206, 17, 45);
        Color chiBlue = new Color(85, 193, 232);

        //Define all my objects
        Ellipse2D.Double centerRing = new Ellipse2D.Double(120, 120, 280, 280);
        int[] xCoords = new int[] {260, 277, 347, 293, 347, 277, 260, 243, 173, 227, 173, 243}; //define x coords for redStar, y coords for blueStar
        int[] yCoords = new int[] {160, 227, 210, 260, 310, 293, 360, 293, 310, 260, 210, 227}; //define y cords for redStar, x coords for redStar
        Polygon redStar = new Polygon(xCoords, yCoords, 12);
        Polygon blueStar = new Polygon(yCoords, xCoords, 12); //switch x and y to reflect blue star over y=x
        Rectangle topStripeOuter = new Rectangle(0, 20, 500, 20);
        Rectangle topStripeInner = new Rectangle(0, 40, 500, 20);
        Rectangle bottomStripeInner = new Rectangle(0, 460, 500, 20);
        Rectangle bottomStripeOuter = new Rectangle(0, 480, 500, 20);

        //Draw all of the elements
        //Draw white background
        g2.setColor(Color.white);
        g2.fillRect(0,0,520,520);
        //Draw blue objects
        g2.setColor(chiBlue);
        g2.setStroke(thin);
        g2.draw(blueStar);
        g2.setStroke(thick);
        g2.draw(centerRing);
        g2.fill(topStripeOuter);
        g2.fill(bottomStripeOuter);
        //Draw red objects
        g2.setColor(chiRed);
        g2.setStroke(thin);
        g2.fill(redStar);
        g2.fill(topStripeInner);
        g2.fill(bottomStripeInner);
    }
}
