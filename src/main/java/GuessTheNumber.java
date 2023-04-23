import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {

    // Create a main() method

        // Use the following code to create a random number from 1 to 100:
        // Note: you may have to import the Random class
        // int randomNumber = new Random().nextInt(100) + 1;

    public static void main(String[] args) {

        int randomNumber = new Random().nextInt(100) + 1;
        int guessAttempts = 6;
        int numberOfGuesses = 0;
        int userGuess;

        boolean loop = true;

        while (loop) {
            while (guessAttempts > 0) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Please guess a number between 1 and 100. (You have " + guessAttempts + " guesses left): ");
                //String userInput = scanner.nextLine();
                try {
                    //userGuess = Integer.parseInt(userInput);
                    userGuess = scanner.nextInt();
                    numberOfGuesses++;

                    loop = false;
                    if (userGuess <= 0 || userGuess > 100) {
                        throw new NumberFormatException("Number is out of range");
                    }

                    if (userGuess == randomNumber) {
                        System.out.println();
                        System.out.println("Congrats, you guess correctly in " + numberOfGuesses + " guesses!");
                        System.exit(0);
                    }
                    if (userGuess < randomNumber) {
                        System.out.println();
                        System.out.println("Sorry, you guessed too low.");
                        guessAttempts--;
                    }
                    if (userGuess > randomNumber) {
                        System.out.println();
                        System.out.println("Sorry, you guessed too high.");
                        guessAttempts--;
                    }

                } catch (NumberFormatException e) {
                    System.out.println();
                    System.out.println("Invalid entry. Please enter a number between 1 and 100.");
                } catch (InputMismatchException e) {
                    System.out.println();
                    System.out.println("Invalid Entry. Please enter a valid integer.");
                }

            }
        }
        System.out.println("You are out of guesses. The correct number was " + randomNumber + ". Better luck next time.");
    }

}
