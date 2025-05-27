import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = (int)(Math.random() * 100) + 1;
        int guess = 0;
        System.out.println("Guess a number between 1 and 100:");
        while (guess != number) {
            guess = scanner.nextInt();
            if (guess < number) {
                System.out.println("Too low");
            } else if (guess > number) {
                System.out.println("Too high");
            } else {
                System.out.println("You guessed it!");
            }
        }
        scanner.close();
    }
}
