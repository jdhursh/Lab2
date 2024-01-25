// This program prompts the user to think of a random number between 1 and 10, then will attempt to guess that number

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class GuessRandom {

    public static void main(String[] args) {
//        Main method that creates the Scanner and executes all other methods

        Scanner console = new Scanner(System.in);

        intro();
        System.out.println();
        isReady(console);
        System.out.println();
        guessNum(console);
        playAgain(console);

    }

    public static void playAgain(Scanner console) {
//        This method will determine if the user wants play the game again

        boolean yes_or_no = true;

        while (yes_or_no) {
            System.out.println();
            System.out.print("Would you like to play again? y/n ");
            if (Objects.equals(console.next(), "y")) {
                System.out.println();
                isReady(console);
                System.out.println();
                guessNum(console);
            } else {
                System.out.println();
                System.out.println("Thanks for playing!");
                yes_or_no = false;
            }
        }

    }

    public static void isReady(Scanner console) {
//        Determines if player is ready to begin

        boolean ready = false;
        while (!ready) {
            System.out.print("Are you ready? y/n ");
            if (Objects.equals(console.next(), "y")) {
                ready = true;
            }
        }
    }

    public static void intro() {
//        Handles the introduction of the program

        System.out.println("Welcome to number guesser!");
        System.out.println("Think of a number between 1-10 and I will try to guess it.");
    }

    public static void guessNum(Scanner console) {
//        This method handles user input on whether the guesses are right or wrong, and handles wrong inputs.

        int guesses = 0;
        boolean your_num = false;


        while (!your_num) {
            guesses++;
            console.nextLine();
            int num = randomNum();
            System.out.print("Is your number " + num + "? y/n: ");
            String input = console.next();
            if (Objects.equals(input, "y")) {
                if (guesses == 1) {
                    System.out.println("I guessed your number of " + num + " correct in " + guesses + " guess.");

                } else {
                    System.out.println("I guessed your number of " + num + " correct in " + guesses + " guesses.");

                }
                your_num = true;
            } else if (!Objects.equals(input, "n")) {
                System.out.println();
                System.out.println("Please enter y or n");
                System.out.println();
            }
        }
    }

    public static int randomNum() {
//        Creates random numbers between 1 and 10

        Random rand = new Random();
        return rand.nextInt(1, 11);
    }
}
