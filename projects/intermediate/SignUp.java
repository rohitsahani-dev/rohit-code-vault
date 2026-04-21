package projects.intermediate;

import java.util.*;

public class SignUp {

    static Scanner sc = new Scanner(System.in);

    static String[] names = new String[100];
    static String[] phones = new String[100];
    static String[] passwords = new String[100];
    static String[] dobs = new String[100];
    static int userCount = 0;

    public static void main(String[] args) {

        while (true) {
            System.out.println("\nPlease enter 1 for Sign up.");
            System.out.println("Please enter 2 for Quit.");
            System.out.println("Please enter 3 to View Users.");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                signup();
            } else if (choice == 2) {
                System.out.println("Thank you for using the Application.");
                break;
            } else if (choice == 3) {
                viewUsers();
            } else {
                System.out.println("Invalid choice.");
            }
        }
    }

    static void signup() {

        String name, phone, password, confirmPassword, dob;

        while (true) {

            System.out.print("\nPlease enter your full name: ");
            name = sc.nextLine();

            if (name.length() <= 4) {
                System.out.println("Name must be more than 4 characters.");
                continue;
            }

            System.out.print("Please enter your mobile number: ");
            phone = sc.nextLine();

            if (!phone.matches("9\\d{9}")) {
                System.out.println("Mobile number must be 10 digits starting with 9.");
                continue;
            }

            System.out.print("Please enter your password: ");
            password = sc.nextLine();

            if (!password.matches("[A-Za-z]+[@&]\\d+")) {
                System.out.println("Password must start with letters, contain @ or &, and end with numbers.");
                continue;
            }

            System.out.print("Please confirm your password: ");
            confirmPassword = sc.nextLine();

            if (!password.equals(confirmPassword)) {
                System.out.println("Your passwords are not matching.");
                continue;
            }

            System.out.print("Please enter your Date of Birth (DD/MM/YYYY): ");
            dob = sc.nextLine();

            if (!dob.matches("\\d{2}/\\d{2}/\\d{4}")) {
                System.out.println("You have entered the Date of Birth in invalid format.");
                continue;
            }

            int year = Integer.parseInt(dob.substring(6));
            int age = 2026 - year;

            if (age < 21) {
                System.out.println("You must be at least 21 years old.");
                continue;
            }

            names[userCount] = name;
            phones[userCount] = phone;
            passwords[userCount] = password;
            dobs[userCount] = dob;
            userCount++;

            System.out.println("You have successfully signed up.");
            break;
        }
    }

    static void viewUsers() {

        if (userCount == 0) {
            System.out.println("No users registered yet.");
            return;
        }

        System.out.println("\n--- Registered Users ---");

        for (int i = 0; i < userCount; i++) {
            System.out.println("\nUser " + (i + 1));
            System.out.println("Name: " + names[i]);
            System.out.println("Phone: " + phones[i]);
            System.out.println("DOB: " + dobs[i]);
        }
    }
}
