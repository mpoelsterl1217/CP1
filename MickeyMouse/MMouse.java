import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.Color;
import javax.swing.JComponent;

public class MMouse extends JComponent{
  public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D) g;

		g2.setColor(Color.black);

		Ellipse2D.Double head = new Ellipse2D.Double(100, 100, 200, 200);
		g2.fill(head);

    Ellipse2D.Double earL = new Ellipse2D.Double(50,50,100,100);
    g2.fill(earL);

    Ellipse2D.Double earR = new Ellipse2D.Double(250,50,100,100);
    g2.fill(earR);
	}
}
