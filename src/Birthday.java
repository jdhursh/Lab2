/*This program takes the birthdays of two people along with today's date, tells the user how many days are until each birthday,
  and determines which birthday is closer*/

import java.util.Scanner;

import static java.lang.Math.abs;

public class Birthday {
    public static void main(String[] args) {
//        main method executing each other method

        intro();

        String[] stringNums = userInput();

        int[][] nums = stringToInt(stringNums);

        finale(nums);

    }

    public static void intro() {
//        The introduction and instructions for the program

        System.out.println("----------------------------------");
        System.out.println("How many days until your birthday?");
        System.out.println("----------------------------------");
        System.out.println();
        System.out.println("----------------------------------------------");
        System.out.println("Dates should be formatted like the following: ");
        System.out.println("05/27");
        System.out.println("05 27");
        System.out.println("----------------------------------------------");
        System.out.println();
    }


    public static void finale(int[][] nums) {
//        This method shows the results of days remaining and handles the logic for determining which one is sooner.

        int bday1 = dayMath(nums, 0);
        int bday2 = dayMath(nums, 1);

        System.out.println();

        System.out.println("There are " + bday1 + " days until birthday 1.");
        System.out.println("There are " + bday2 + " days until birthday 2.");
        System.out.println();

        if (bday1 < bday2) {
            System.out.println("Birthday 1 is sooner than birthday 2.");
        } else if (bday2 < bday1) {
            System.out.println("Birthday 2 is sooner than birthday 1.");

        } else {
            System.out.println("Birthday 1 and 2 are the same day!");
        }
    }

    public static int dayMath(int[][] nums, int n) {
//        This method determines how many days there are until each birthday

        int today = monthToDay(nums[2][0], nums[2][0]) + nums[2][1];

        int days = monthToDay(nums[n][0], nums[2][0]) + nums[n][1];
        int diff = days - today;
        if (diff < 0) {
            return 365 + diff;
        } else {
            return diff;
        }
    }


    public static String[] userInput() {
//        This method prompts the user and records their responses into an array.

        try (Scanner console = new Scanner(System.in)) {

            System.out.println("Please enter the month and day of birthday 1: ");
            String dateOfBirth1 = console.nextLine();
            while (dateOfBirth1.length() != 5) {
                System.out.println("Please enter the month and day of birthday 1: ");
                dateOfBirth1 = console.nextLine();
            }

            System.out.println("Please enter the month and day of birthday 2: ");
            String dateOfBirth2 = console.nextLine();
            while (dateOfBirth2.length() != 5) {
                System.out.println("Please enter the month and day of birthday 2: ");
                dateOfBirth2 = console.nextLine();
            }

            System.out.println("Please enter today's month and day: ");
            String todaysDate = console.nextLine();
            while (todaysDate.length() != 5) {
                System.out.println("Please enter today's month and day: ");
                todaysDate = console.nextLine();

            }


            return new String[]{dateOfBirth1, dateOfBirth2, todaysDate};

        }

    }

    public static String[] splitDate(String[] dates, int n) {
//        This method splits the entered date either by slashes or spaces

        String date = dates[n];
        String[] elements = {};
        if (date.contains("/")) {
            elements = date.split("/");
        } else if (date.contains(" ")) {
            elements = date.split(" ");
        }
        return elements;
    }

    public static int[][] stringToInt(String[] strings) {
//        This method takes the String inputs from userInput, splits them, and turns them into integers

        int[] date1 = new int[0];
        int[] date2 = new int[0];
        int[] date3 = new int[0];

        for (int i = 0; i < strings.length; i++) {

            String[] elements = splitDate(strings, i);

            // ex. elements = {"05", "27"}
            int num1 = Integer.parseInt(elements[0]);
            int num2 = Integer.parseInt(elements[1]);

            switch (i) {
                case 0:
                    date1 = new int[]{num1, num2};
                    break;
                case 1:
                    date2 = new int[]{num1, num2};
                    break;
                case 2:
                    date3 = new int[]{num1, num2};
                    break;
            }
        }
        return new int[][]{date1, date2, date3};

    }

    public static int monthToDay(int birthMonth, int todaysMonth) {
//        This method determines how many days there are in each month, and adds them based on userInput

        int jan, mar, may, jul, aug, oct, dec;
        jan = mar = may = jul = aug = oct = dec = 31;
        int apr, jun, sep, nov;
        apr = jun = sep = nov = 30;
        int feb = 29; // 2024 is a leap year
        int days = 0;

        int[] months = {jan, feb, mar, apr, may, jun, jul, aug, sep, oct, nov, dec};

        int monthDiff = birthMonth - todaysMonth;
        int absMonthDiff = abs(monthDiff);

        if (monthDiff >= 0) {
            for (int i = 0; i < birthMonth - 1; i++) {
                days += months[i];
            }
        } else {
            for (int i = 0; i < 12; i++) {
                days += months[i];
            }
            for (int i = 0; i < absMonthDiff; i++) {
                days += months[i];

            }

        }
        return days;

    }
}