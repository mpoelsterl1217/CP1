public class Division{
    public static void main(String[] args){
        double wholeNum1 = 5.0;
        double wholeNum2 = 2.0;

        int wholeResult = wholeNum1 / wholeNum2;
        System.out.println("int result: " + wholeResult);

        double doubleResult = wholeNum1 / wholeNum2;
        System.out.println("double result: " + doubleResult);

        int remainderResult = wholeNum1 % wholeNum2;
        System.out.println("remainder result: " + remainderResult);
    }
}
