import javax.swing.JOptionPane;

public class UserInputPane{
	public static void main(String[] args){

		String firstName = JOptionPane.showInputDialog("First Name");
		String lastName = JOptionPane.showInputDialog("Last Name");

		JOptionPane.showMessageDialog(null, firstName + " " + lastName);

	}
}
