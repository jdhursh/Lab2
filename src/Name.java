//This program asks the user to enter the desired amount of names, then determines which name or names are the longest

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.*;

public class Name {
    public static void main(String[] args) {
//        Main method creating the Scanner and executing other methods

        Scanner console = new Scanner(System.in);

        System.out.print("How many names? ");
        int num_of_names = numberOfNames(console);
        console.nextLine();

        longestName(console, num_of_names);

    }

    public static int numberOfNames(Scanner console) {
//        Determines how many names the user is going to input and catches incorrect inputs

        boolean caughtYa = true;
        int num_of_names = 0;

        while (caughtYa) {
            try {
                caughtYa = false;
                num_of_names = console.nextInt();
            } catch (InputMismatchException e) {
                System.out.print("Try again: ");
                console.next();
                caughtYa = true;
            }
        }
        return num_of_names;
    }

    public static void longestName(Scanner console, int num) {
//        This method determines what the longest name(s) is from the entered names

        ArrayList<String> names = new ArrayList<>();

//        Prompts user based on how many names they want to enter, and enters them into an ArrayList
        for (int i = 0; i < num; i++) {
            System.out.println();
            System.out.println("Name #" + (i + 1) + "?");
            names.add(console.nextLine().toLowerCase());
        }

        ArrayList<Integer> lengths = new ArrayList<>();

//        Converts each name into an Integer based on their length, and adds them to an ArrayList
        for (int i = 0; i < num; i++) {
            lengths.add(names.get(i).length());
        }

//        Determines the index of the longest name, and sees if there are other
//        instances of that number in the ArrayList
        int lengthsMax = Collections.max(lengths);
        int longestNameIndex = lengths.indexOf(lengthsMax);
        int frequency_of_length = Collections.frequency(lengths, lengthsMax);

        System.out.println();

//         If there is more than one instance of the longest length, this will add them all to an ArrayList
        if (frequency_of_length >= 2) {
            ArrayList<String> multiple_names = new ArrayList<>();

            for (int i = 0; i < lengths.size(); i++) {
                if (lengths.get(i) == lengthsMax) {
                    multiple_names.add(capitalize(names.get(i)));
                }
            }

//            Determines if there is either 2 or more than 2 instances of the longest
//            name length in order to format properly
            System.out.print(multiple_names.getFirst());
            for (int i = 1; i < frequency_of_length; i++) {
                if (frequency_of_length > 2) {
                    if (i == frequency_of_length - 1) {
                        System.out.print(" & " + multiple_names.get(i));
                    } else {
                        System.out.print(", " + multiple_names.get(i));
                    }

                } else {
                    System.out.print(" & " + multiple_names.get(i));
                }
            }
            System.out.print(" have the longest names.");
        } else {
            String theName = names.get(longestNameIndex);
            System.out.println(capitalize(theName) + "'s name is the longest.");
        }

    }

    public static String capitalize(String name) {
//        Capitalizes the first letter of the entered string

        String cap_first_letter = name.substring(0, 1).toUpperCase();
        return cap_first_letter + name.substring(1);
    }
}
