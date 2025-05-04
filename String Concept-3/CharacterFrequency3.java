import java.util.Scanner;

public class CharacterFrequency3 {

    public static String[] findCharacterFrequency(String text) {
        char[] charArray = text.toCharArray();
        int[] frequency = new int[charArray.length];
        String[] result = new String[charArray.length];
        
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] != '0') {
                frequency[i] = 1;
                for (int j = i + 1; j < charArray.length; j++) {
                    if (charArray[i] == charArray[j]) {
                        frequency[i]++;
                        charArray[j] = '0';
                    }
                }
                result[i] = charArray[i] + ": " + frequency[i];
            }
        }
        
        return result;
    }

    public static void displayFrequency(String[] frequencyData) {
        System.out.println("Character Frequency");
        for (String data : frequencyData) {
            if (data != null) {
                System.out.println(data);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        String[] frequencyData = findCharacterFrequency(input);
        displayFrequency(frequencyData);
    }
}
