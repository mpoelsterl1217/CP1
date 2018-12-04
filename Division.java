public class Division{
    public static void main(String[] args){
        int wholeNum1 = 5;
        int wholeNum2 = 2;

        int wholeResult = wholeNum1 / wholeNum2;
        System.out.println("int result: " + wholeResult);

        double doubleResult = wholeNum1 / wholeNum2;
        System.out.println("double result: " + doubleResult);

        int remainderResult = wholeNum1 % wholeNum2;
        System.out.println("remainder result: " + remainderResult);
    }
}
