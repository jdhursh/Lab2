// This program takes the name, number of scores, and scores of an individual and converts them into an overall grade

import java.util.Scanner;

public class GradePointAverage {
    public static void main(String[] args) {
//        Main method the creates Scanner and executes the grade method
        Scanner console = new Scanner(System.in);

        grade(console);
    }

    public static void grade(Scanner console) {
//        This method handles the entry of the record of the student

//        Handles user input and splits it into an array of strings
        System.out.print("Enter a student's record: ");
        String input = console.nextLine();
        String[] inputSplit = input.split(" ");
        String name = inputSplit[0].toLowerCase();

//        Handles the NumberFormatException, ensuring proper input from the user
        int num_of_scores = 0;
        boolean caughtYa = true;
        while (caughtYa) {
            try {
                caughtYa = false;
                num_of_scores = Integer.parseInt(inputSplit[1]);

            } catch (NumberFormatException e) {
                System.out.println("There was a mistake. Try again.");
                System.out.println();
                System.out.print("Enter a student's record: ");
                input = console.nextLine();
                inputSplit = input.split(" ");
                caughtYa = true;

            }
        }


//        Does the summation and division of the entered numbers to output a grade
        int score_sums = 0;

        for (int i = 2; i < num_of_scores + 2; i++) {
            score_sums += Integer.parseInt(inputSplit[i]);
        }

        double gpa = (double) score_sums / num_of_scores;

        System.out.println();

        System.out.print(Name.capitalize(name) + "'s grade is ");
        if ((gpa * 100) % 10 == 0) {
            System.out.printf("%.1f", gpa);
        } else {
            System.out.printf("%.2f", gpa);
        }
        System.out.println();


    }
}
