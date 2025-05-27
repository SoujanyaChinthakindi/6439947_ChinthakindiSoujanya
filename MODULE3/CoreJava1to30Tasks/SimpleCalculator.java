import java.util.Scanner;
public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first integer: ");
        int num1 = scanner.nextInt();
        System.out.print("Enter the second integer: ");
        int num2 = scanner.nextInt();
        System.out.println("\nChoose an operation:");
        System.out.println("1. Addition (+)");
        System.out.println("2. Subtraction (-)");
        System.out.println("3. Multiplication (*)");
        System.out.println("4. Division (/)");
        System.out.print("Enter your choice (1/2/3/4): ");
        int choice = scanner.nextInt();
        int result;
        switch (choice) {
            case 1:
                result = num1 + num2;
                System.out.println("\nResult: " + num1 + " + " + num2 + " = " + result);
                break;
            case 2:
                result = num1 - num2;
                System.out.println("\nResult: " + num1 + " - " + num2 + " = " + result);
                break;
            case 3:
                result = num1 * num2;
                System.out.println("\nResult: " + num1 + " * " + num2 + " = " + result);
                break;
            case 4:
                if (num2 == 0) {
                    System.out.println("\nError: Division by zero is not allowed.");
                } else {
                    result = num1 / num2; 
                    System.out.println("\nResult: " + num1 + " / " + num2 + " = " + result);
                }
                break;
            default:
                System.out.println("\nInvalid choice.");
                break;
        }
        scanner.close();
    }
}
