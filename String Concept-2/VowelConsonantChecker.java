import java.util.Scanner;

public class VowelConsonantChecker {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        System.out.println("Enter a string:");
        String input = sc.nextLine();

        
        String[][] result = processString(input);

        
        displayResult(result);
    }

  
    public static String checkCharacterType(char c) {
       
        if (c >= 'A' && c <= 'Z') {
            c = (char) (c + 32);
        }

        if (c >= 'a' && c <= 'z') {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        } else {
            return "Not a Letter";
        }
    }

  
    public static String[][] processString(String str) {
        int length = str.length();
        String[][] output = new String[length][2];

        for (int i = 0; i < length; i++) {
            char ch = str.charAt(i);
            output[i][0] = String.valueOf(ch);
            output[i][1] = checkCharacterType(ch);
        }

        return output;
    }

   
    public static void displayResult(String[][] array) {
        System.out.println("Character\tType");
        System.out.println("-------------------------");

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i][0] + "\t\t" + array[i][1]);
        }
    }
}
