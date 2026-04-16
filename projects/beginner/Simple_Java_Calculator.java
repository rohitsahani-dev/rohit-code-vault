package projects.beginner;
    // Simple calculator
import java.util.Scanner;

public class Simple_Java_Calculator{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int a = sc.nextInt();

        System.out.print("Enter second number: ");
        int b = sc.nextInt();

        System.out.println("Add: " + (a + b));
        System.out.println("Subtract: " + (a - b));
        System.out.println("Multiply: " + (a * b));

        if (b != 0) {
            System.out.println("Divide: " + (a / b));
        } else {
            System.out.println("Cannot divide by zero");
        }
        sc.close();
    }
}

