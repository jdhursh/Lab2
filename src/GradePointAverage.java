import java.util.Scanner;

public class GradePointAverage {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        grade(console);
    }

    public static void grade(Scanner console) {
        System.out.println("Enter a student's record: ");
        String input = console.nextLine();
        String[] inputSplit = input.split(" ");

        int num_of_scores = Integer.parseInt(inputSplit[1]);

        int score_sums = 0;

        for (int i = 2; i < num_of_scores + 2; i++){
            score_sums += Integer.parseInt(inputSplit[i]);
        }

        double gpa = (double) score_sums /num_of_scores;

        if ((gpa*100)%10 == 0){
            System.out.print(inputSplit[0] + "'s grade is ");
            System.out.printf("%.1f", gpa);
        } else {
            System.out.print(inputSplit[0] + "'s grade is ");
            System.out.printf("%.2f", gpa);
        }


    }
}
