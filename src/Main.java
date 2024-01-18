import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int birthday[] = userInput();
        System.out.println("Month: " + birthday[0]);
        System.out.println("Day: " + birthday[1]);
        System.out.println("Year: " + birthday[2]);
    }

    public static int[] userInput() {
        Scanner console = new Scanner(System.in).useDelimiter("\\s*/\\s*");

        System.out.println("Please enter your date of birth: ");
        int month = console.nextInt();
        int day = console.nextInt();
        int year = console.nextInt();

        return new int[]{month, day, year};
    }
}