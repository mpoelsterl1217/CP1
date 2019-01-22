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

	      /******** Put your code here  *********/
        BasicStroke thick = new BasicStroke(40.0f);
        BasicStroke gridStroke = new BasicStroke(1.0f);
        g2.setStroke(thick);
        Ellipse2D.Double logoRing = new Ellipse2D.Double(120, 120, 280, 280); //Creates Ellipes object at 100,100 with width 200, height 200
        //g2.draw(logoRing); //fills the circle with blue

        g2.setStroke(gridStroke);
        Ellipse2D.Double guideCircleCenter = new Ellipse2D.Double(160, 160, 200, 200); //Creates Ellipes object at 100,100 with width 200, height 200
        g2.draw(guideCircleCenter); //fills the circle with blue
        Ellipse2D.Double guideCircle1 = new Ellipse2D.Double(160, 60, 200, 200); //Creates Ellipes object at 100,100 with width 200, height 200
        g2.draw(guideCircle1); //fills the circle with blue
        Ellipse2D.Double guideCircle2 = new Ellipse2D.Double(160, 260, 200, 200); //Creates Ellipes object at 100,100 with width 200, height 200
        g2.draw(guideCircle2); //fills the circle with blue
        Ellipse2D.Double guideCircle3 = new Ellipse2D.Double(73, 110, 200, 200); //Creates Ellipes object at 100,100 with width 200, height 200
        g2.draw(guideCircle3); //fills the circle with blue
        Ellipse2D.Double guideCircle4 = new Ellipse2D.Double(73, 210, 200, 200); //Creates Ellipes object at 100,100 with width 200, height 200
        g2.draw(guideCircle4); //fills the circle with blue
        Ellipse2D.Double guideCircle5 = new Ellipse2D.Double(247, 110, 200, 200); //Creates Ellipes object at 100,100 with width 200, height 200
        g2.draw(guideCircle5); //fills the circle with blue
        Ellipse2D.Double guideCircle6 = new Ellipse2D.Double(247, 210, 200, 200); //Creates Ellipes object at 100,100 with width 200, height 200
        g2.draw(guideCircle6); //fills the circle with blue

        int[] xPoints = new int[] {260, 277, 347, 293, 347, 277, 260, 243, 173, 227, 173, 243};
        int[] yPoints = new int[] {160, 227, 210, 260, 310, 293, 360, 293, 310, 260, 210, 227};
        Polygon star = new Polygon(xPoints, yPoints, 12);
        g2.drawPolygon(star);

        Polygon hex = new Polygon(yPoints, xPoints, 6);
        g2.drawPolygon(hex);
        // comment this out once you have finished
        g2.setStroke(gridStroke);
        drawGrid(g2);
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
