import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Range {
    public static void main(String[] args) {

        int input = userInput();
        int range = digitRange(input);

        System.out.println();
        System.out.println("The range of " + input + " is " + range + ".");


    }

    public static int userInput(){
        System.out.println("please enter a number: ");
        Scanner console = new Scanner(System.in);

        return console.nextInt();
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


