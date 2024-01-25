import java.util.*;

public class Range {
    public static void main(String[] args) {

        int input = userInput();
        int range = digitRange(input);

        System.out.println();
        System.out.println("The range of " + input + " is " + range + ".");


    }

    public static int userInput(){
        boolean caughtYa = true;
        int num = 0;
        Scanner console = new Scanner(System.in);

        System.out.print("Please enter a number: ");

        while (caughtYa) {
            try {
                caughtYa = false;
                num = console.nextInt();
            } catch (InputMismatchException e) {
                System.out.println();
                System.out.println("That is not a number.");
                System.out.println();
                System.out.print("Please enter a number: ");

                console.next();
                caughtYa = true;
            }
        }
        return num;
    }

    public static int digitRange(int num) {
        ArrayList<Integer> numbers = new ArrayList<>();

        int length = 0;

        while (num > 0) {
            numbers.add(num % 10);
            num /= 10;
            length++;
        }

        if (length == 1){
            return 1;
        } else {
            int max = Collections.max(numbers);
            int min = Collections.min(numbers);

            return max - min + 1;
        }

    }
}


