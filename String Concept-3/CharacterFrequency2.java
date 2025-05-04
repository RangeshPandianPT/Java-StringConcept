import java.util.Scanner;

public class CharacterFrequency2 {

    public static char[] uniqueCharacters(String text) {
        boolean[] seen = new boolean[256];
        int uniqueCount = 0;
        
        for (int i = 0; i < text.length(); i++) {
            if (!seen[text.charAt(i)]) {
                seen[text.charAt(i)] = true;
                uniqueCount++;
            }
        }

        char[] uniqueChars = new char[uniqueCount];
        int index = 0;
        for (int i = 0; i < text.length(); i++) {
            if (seen[text.charAt(i)]) {
                uniqueChars[index] = text.charAt(i);
                index++;
                seen[text.charAt(i)] = false;
            }
        }
        
        return uniqueChars;
    }

    public static String[][] findCharacterFrequency(String text) {
        int[] frequency = new int[256];
        for (int i = 0; i < text.length(); i++) {
            frequency[text.charAt(i)]++;
        }

        char[] uniqueChars = uniqueCharacters(text);
        String[][] result = new String[uniqueChars.length][2];

        for (int i = 0; i < uniqueChars.length; i++) {
            result[i][0] = String.valueOf(uniqueChars[i]);
            result[i][1] = String.valueOf(frequency[uniqueChars[i]]);
        }

        return result;
    }

    public static void displayFrequency(String[][] frequencyData) {
        System.out.println("Character | Frequency");
        for (int i = 0; i < frequencyData.length; i++) {
            System.out.println(frequencyData[i][0] + "        | " + frequencyData[i][1]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        String[][] frequencyData = findCharacterFrequency(input);
        displayFrequency(frequencyData);
    }
}

