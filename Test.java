import java.util.Scanner;

public class Test{
  public static void main(String[] args) {
    Scanner kin = new Scanner(System.in);
    int[] nums = new int[10];
    for (int i = 0; i < nums.length; i++) {
      System.out.print("Enter a number: ");
      nums[i] = kin.nextInt();
    }
  }
}
