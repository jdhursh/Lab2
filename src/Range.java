// This program takes a number and returns the range of that number to the user.

import java.util.*;

public class Range {
    public static void main(String[] args) {
//        Main method, executes other methods and handles the output of the program

        int input = userInput();
        int range = digitRange(input);

        System.out.println();
        System.out.println("The range of " + input + " is " + range + ".");


    }

    public static int userInput() {
//        This method handles the users' input and returns the number entered


        int num = 0;
        Scanner console = new Scanner(System.in);

        System.out.print("Please enter a number between 1 and 2147483647: ");

//        This while loop will loop through try-catch while the user fails to enter a valid entry.
        boolean caughtYa = true;
        while (caughtYa) {
            try {
                caughtYa = false;
                num = console.nextInt();
            } catch (InputMismatchException e) {
                System.out.println();
                System.out.println("That is not a number, or the number is too large.");
                System.out.println();
                System.out.print("Please enter a number 1 and 2147483647: ");

                console.next();
                caughtYa = true;
            }
        }
        return num;
    }

    public static int digitRange(int num) {
/*        This method takes the input from userInput, and loops through it, adding the last digit to the ArrayList,
           then returns the range of that number */
        ArrayList<Integer> numbers = new ArrayList<>();

        int length = 0;

        while (num > 0) {
            numbers.add(num % 10);
            num /= 10;
            length++;
        }

        if (length == 1) {
            return 1;
        } else {
            int max = Collections.max(numbers);
            int min = Collections.min(numbers);

            return max - min + 1;
        }

    }
}


