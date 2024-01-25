import java.util.Scanner;

public class GradePointAverage {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        grade(console);
    }

    public static void grade(Scanner console) {
        int num_of_scores = 0;

        boolean caughtYa = true;
        System.out.print("Enter a student's record: ");
        String input = console.nextLine();
        String[] inputSplit = input.split(" ");
        String name = inputSplit[0].toLowerCase();

        while(caughtYa) {
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


        int score_sums = 0;

        for (int i = 2; i < num_of_scores + 2; i++){
            score_sums += Integer.parseInt(inputSplit[i]);
        }

        double gpa = (double) score_sums /num_of_scores;

        System.out.println();

        System.out.print(Name.capitalize(name) + "'s grade is ");
        if ((gpa*100)%10 == 0){
            System.out.printf("%.1f", gpa);
        } else {
            System.out.printf("%.2f", gpa);
        }
        System.out.println();


    }
}
