import javax.swing.JFrame;

public class FrameDemo{
	public static void main(String[] args){
		JFrame frame = new JFrame("Frame Demo");  //creates the frame object
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //sets what happens when you click X, closes operation
		frame.setSize(999, 999); //sets the size of the frame

    Shapes r = new Shapes(); //new shapes object named r
	  frame.add(r); //puts the shapes object r in the frame

		frame.setVisible(true); //makes the frame visible
	}
}
