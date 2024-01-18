import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public static int userInput() {
        Scanner console = new Scanner(System.in);

        System.out.println("Please enter your date of birth: ");

        return console.nextInt();
    }
}