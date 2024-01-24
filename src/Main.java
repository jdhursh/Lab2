import java.util.Scanner;

import static java.lang.Math.abs;

public class Main {
    public static void main(String[] args) {
        System.out.println(monthToDay(1, 3));

    }

    public static String[] userInput() {
        try (Scanner console = new Scanner(System.in)) {

            System.out.println("Please enter the month and day of birthday 1: ");
            String dateOfBirth1 = console.nextLine();
            System.out.println("Please enter the month and day of birthday 2: ");
            String dateOfBirth2 = console.nextLine();
            System.out.println("Please enter today's month and day: ");
            String todaysDate = console.nextLine();

            return new String[]{dateOfBirth1, dateOfBirth2, todaysDate};

        }

    }

    public static int[][] stringToInt(String[] strings) {

        int[] date1 = new int[0];
        int[] date2 = new int[0];
        int[] date3 = new int[0];

        for (int i = 0; i < strings.length; i++) {
            String date = strings[i];
            String[] elements = date.split(" ");
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

        int jan, mar, may, jul, aug, oct, dec;
        jan = mar = may = jul = aug = oct = dec = 31;
        int apr, jun, sep, nov;
        apr = jun = sep = nov = 30;
        int feb = 28;
        int days = 0;

        int[] months = {jan, feb, mar, apr, may, jun, jul, aug, sep, oct, nov, dec};

        int monthDiff = birthMonth - todaysMonth;
        int absMonthDiff = abs(monthDiff);

        if (monthDiff >= 0) {
            for (int i = 0; i < birthMonth - 1; i++) {
                days += months[i];
            }
            return days;
        } else {
            for (int i = 0; i < 12; i++) {
                days += months[i];
            }
            for (int i = 0; i < absMonthDiff; i++) {
                days += months[i];

            }
            return days;

        }

    }
}