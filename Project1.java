import java.util.Scanner;

public class Project1 {
  public static void main(String[] args) {
    //Create Scanner
    Scanner scan = new Scanner(System.in);

    //Welcome Message
    System.out.println("Welcome to the Grade Calculator");

    //Take in homework grades
    System.out.println("\nPlease Enter Grades for the Homework");
    System.out.println("HW1: ");
    double hw1 = scan.nextDouble();
    System.out.println("HW2: ");
    double hw2 = scan.nextDouble();
    System.out.println("HW3: ");
    double hw3 = scan.nextDouble();

    //Take in Quizzes
    System.out.println("\nPlease Enter Grades for the Quizzes");
    System.out.println("Quiz1: ");
    double quiz1 = scan.nextDouble();
    System.out.println("Quiz2: ");
    double quiz2 = scan.nextDouble();

    //Take in final
    System.out.println("\nPlease Enter Grades for the Final Exam");
    System.out.println("Final: ");
    double finalGrade = scan.nextDouble();

    //Calculate Homework Average
    double hwAvg = (hw1 + hw2 + hw3)/3.0;

    //Calculate Quiz Average
    double quizAvg = (quiz1 + quiz2)/2.0;

    //Calculate Weighted Average of Grade
    double grade = ((hwAvg*20) + (quizAvg*50) + (finalGrade*30))/100.0;

    //Output category and final Average
    System.out.println("\nThe average of the Homework is: " + hwAvg + "%");
    System.out.println("The average of the Quizzes is: " + quizAvg + "%");
    System.out.println("The average of the Final Exam is: " + finalGrade + "%");
    System.out.println("\nThe Final grade is: " + grade + "%");
  }
}
