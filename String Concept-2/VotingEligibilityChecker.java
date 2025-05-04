import java.util.Scanner;
import java.util.Random;

public class VotingEligibilityChecker {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

       
        System.out.println("Enter the number of students:");
        int n = sc.nextInt();

        
        int[] ages = generateRandomAges(n);

        
        String[][] votingData = canVote(ages);

       
        displayResult(votingData);
    }

    
    public static int[] generateRandomAges(int n) {
        Random rand = new Random();
        int[] ages = new int[n];

        for (int i = 0; i < n; i++) {
            ages[i] = rand.nextInt(90) + 10; 
        }

        return ages;
    }

    
    public static String[][] canVote(int[] ages) {
        String[][] result = new String[ages.length][2];

        for (int i = 0; i < ages.length; i++) {
            int age = ages[i];
            result[i][0] = String.valueOf(age);

            if (age < 0) {
                result[i][1] = "false"; // Negative age, cannot vote
            } else if (age >= 18) {
                result[i][1] = "true";  // Can vote
            } else {
                result[i][1] = "false"; // Cannot vote
            }
        }

        return result;
    }

    
    public static void displayResult(String[][] data) {
        System.out.println("Age\tCan Vote");
        System.out.println("--------------------");

        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i][0] + "\t" + data[i][1]);
        }
    }
}
