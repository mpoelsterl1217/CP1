import javax.swing.JFrame;

public class DrawingFrame
{
   public static void main(String[] args){

       JFrame frame = new JFrame("ChiTown");
       frame.setSize(500, 540);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       DrawingPicture picture = new DrawingPicture();
       frame.add(picture);

       frame.setVisible(true);
   }
}
