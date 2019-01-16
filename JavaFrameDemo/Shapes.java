import java.awt.*;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;

public class Shapes extends JComponent{

	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D) g; //creates 2d graphics object

		Rectangle box = new Rectangle(5, 10, 50, 30); //creates Rectangle object at 5,10 of width 50, height 30
		g2.draw(box); //Graphics object draws Rectangle box onto the canvas

		g2.setColor(Color.blue); //Sets pen color to blue

		Ellipse2D.Double circle = new Ellipse2D.Double(100, 100, 200, 200); //Creates Ellipes object at 100,100 with width 200, height 200
		g2.fill(circle); //fills the circle with blue

		g2.setColor(Color.black);
		Rectangle bb = new Rectangle(100,100,200,200);
		g2.draw(bb);
		
	}
}
