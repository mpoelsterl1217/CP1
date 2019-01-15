import javax.swing.JFrame;

public class MMFrame {
  public static void main(String[] args){
		JFrame frame = new JFrame("Mickey Mouse");  //creates the frame object
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //sets what happens when you click X
		frame.setSize(500, 500); //sets the size of the frame

    Shapes MM = new Shapes();
	  frame.add(MM);

		frame.setVisible(true); //makes the frame visible
	}
}
