import javax.swing.JFrame;

public class FrameDemo{
	public static void main(String[] args){
		JFrame frame = new JFrame("Frame Demo");  //creates the frame object
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //sets what happens when you click X
		frame.setSize(999, 999); //sets the size of the frame

    Shapes r = new Shapes();
	  frame.add(r);

		frame.setVisible(true); //makes the frame visible
	}
}
