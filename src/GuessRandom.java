import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class GuessRandom {

    public static void main(String[] args) {
    guessNum();

    }

    public static void guessNum() {
        Scanner console = new Scanner(System.in);
        int guesses = 0;
        boolean your_num = false;


        while (!your_num) {
            guesses++;
            int num = randomNum();
            System.out.print("Is your number " + num + "? y/n: ");
            if (Objects.equals(console.next(), "y")) {
                if (guesses == 1) {
                    System.out.println("I guessed your number of " + num + " correct in " + guesses + " guess.");

                } else {
                    System.out.println("I guessed your number of " + num + " correct in " + guesses + " guesses.");

                }
                your_num = true;
            }
        }
    }

    public static int randomNum() {
        Random rand = new Random();
        return rand.nextInt(1, 11);
    }
}
