package refatoracao;
import java.util.Scanner;

public class BadCalculator {
    
    // Global scanner object - bad practice
    static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        BadCalculator calc = new BadCalculator();
        boolean keepRunning = true;
        
        while (keepRunning) {
            // Bad practice: using magic numbers
            System.out.println("Simple Calculator");
            System.out.println("1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Multiply");
            System.out.println("4. Divide");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            
            // Bad practice: using deeply nested conditionals
            if (choice == 1) {
                System.out.print("Enter first number: ");
                int num1 = scanner.nextInt();
                System.out.print("Enter second number: ");
                int num2 = scanner.nextInt();
                System.out.println("Result: " + calc.add(num1, num2));
            } else if (choice == 2) {
                System.out.print("Enter first number: ");
                int num1 = scanner.nextInt();
                System.out.print("Enter second number: ");
                int num2 = scanner.nextInt();
                System.out.println("Result: " + calc.subtract(num1, num2));
            } else if (choice == 3) {
                System.out.print("Enter first number: ");
                int num1 = scanner.nextInt();
                System.out.print("Enter second number: ");
                int num2 = scanner.nextInt();
                System.out.println("Result: " + calc.multiply(num1, num2));
            } else if (choice == 4) {
                System.out.print("Enter first number: ");
                int num1 = scanner.nextInt();
                System.out.print("Enter second number: ");
                int num2 = scanner.nextInt();
                if (num2 == 0) {
                    // Bad practice: not handling exceptions properly
                    System.out.println("Error! Division by zero.");
                } else {
                    System.out.println("Result: " + calc.divide(num1, num2));
                }
            } else if (choice == 5) {
                keepRunning = false;
                System.out.println("Exiting...");
            } else {
                // Bad practice: not handling invalid inputs gracefully
                System.out.println("Invalid choice!");
            }
        }
        
        // Closing scanner object in a bad way
        scanner.close();
    }
    
    public int add(int a, int b) {
        return a + b;
    }
    
    public int subtract(int a, int b) {
        return a - b;
    }
    
    public int multiply(int a, int b) {
        return a * b;
    }
    
    public int divide(int a, int b) {
        return a / b;
    }
}
