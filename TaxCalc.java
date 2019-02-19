import java.util.Scanner;

class TaxCalc {
  public static void main(String[] args) {
    //Create Scanner object
    Scanner kin = new Scanner(System.in);

    //Get input of taxable income
    System.out.println("Calculating Income Tax");
    System.out.println();
    System.out.print("Total income for the year: $");
    double income = kin.nextDouble();

    //Conditional block to determine tax bracket
    double taxDue = 0;
    if (income >= 0 && income <= 9525) {
      //10% bracket
      taxDue = income * .10;
    } else if (income > 9525 && income <= 38700) {
      //12% bracket
      taxDue = 952.50 + ((income - 9525) * .12);
    } else if (income > 38700 && income <= 82500) {
      //22% bracket
      taxDue = 4453.50 + ((income - 38700) * .22);
    } else if (income > 82500 && income <= 157500) {
      //24% bracket
      taxDue = 14089.50 + ((income - 82500) * .24);
    }  else if (income > 157500 && income <= 200000) {
      //32% bracket
      taxDue = 32089.50 + ((income - 157500) * .32);
    }  else if (income > 200000 && income <= 500000) {
      //35% bracket
      taxDue = 45689.50 + ((income - 200000) * .35);
    }  else if (income > 500000) {
      //37% bracket
      taxDue = 150689.50 + ((income - 500000)  * .37);
    }

    //Output Taxes
    System.out.println("Tax to be paid: $" + taxDue);

  }
}
