import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.Color;
import javax.swing.JComponent;

public class MMouse extends JComponent{
  public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D) g;

		Rectangle box = new Rectangle(5, 10, 50, 30);
		g2.draw(box);

		g2.setColor(Color.blue);

		Ellipse2D.Double circle = new Ellipse2D.Double(100, 100, 200, 200);
		g2.fill(circle);

	}
}
