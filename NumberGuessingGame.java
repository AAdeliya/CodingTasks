import java.util.Random;
import java.util.Scanner;

public class  NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Please choose a number from 1 to 10 inclusively.");
        int randomNumber = random.nextInt(10) + 1;

        System.out.println("Enter your guess:");
        int guessedNumber = scanner.nextInt();

        if (guessedNumber == randomNumber) {
            System.out.println("You guessed the number");
        } else {
            System.out.println("You didn't guess the number. It was: " + randomNumber);
        }

        scanner.close();
    }
    
}


    
