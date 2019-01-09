public class Test{
  public static void main(String[] args) {
    System.out.println("Samurai".substring(0,3));

    String str = "How much wood could a woodchuck chuck?";
    String sub = str.substring(32);
    String substr = str.substring(0,4);
    System.out.println(sub + substr);

    String s1 = "Mr. Berg";
    String s2 = "Mrs. Roscoe";
    String s3 = "Mr. Patel";
    String s1sub = s1.substring(4);
    String s2sub = s2.substring(5);
    String s3sub = s3.substring(4);
    System.out.println(s1sub + s2sub + s3sub);


    String fName = "Robert";
    String lName = "Berg";

    String fLet1 = fName.substring(0,1);
    String fLet2 = lName.substring(0,1);

    String rest1 = fName.substring(1);
    String rest2 = lName.substring(1);

    String pl1 = rest1 + fLet1 + "ay";
    String pl2 = rest2 + fLet2 + "ay";

    System.out.println(pl1);
    System.out.println(pl2);

  }
}
