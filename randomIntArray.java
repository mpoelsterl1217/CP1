public class randomIntArray {
  public static void main(String[] args) {

    int[] ints = new int[20];
    for (int i = 0; i < ints.length; i++) {
      ints[i] = (int)(Math.random()*101);
    }
    printArray(ints);
    System.out.println(arraySum(ints));
    System.out.println(arrayMean(ints));
  }
  public static void printArray(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }
  public static int arraySum(int[] arr) {
    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
      sum = sum + arr[i];
    }
    return sum;
  }
  public static int arrayMean(int[] arr) {
    return arraySum(arr)/arr.length;
  }
}
