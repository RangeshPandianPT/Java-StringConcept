import java.util.Scanner;

public class WordLengthTable {

    
    public static int getLengthWithoutUsingLengthMethod(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            
        }
        return count;
    }

    
    public static String[] customSplit(String text) {
        int length = getLengthWithoutUsingLengthMethod(text);

        int wordCount = 1;
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                wordCount++;
            }
        }

        // Store space indexes
        int[] spaceIndexes = new int[wordCount - 1];
        int idx = 0;
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                spaceIndexes[idx++] = i;
            }
        }

        String[] words = new String[wordCount];
        int start = 0;
        for (int i = 0; i < wordCount - 1; i++) {
            int end = spaceIndexes[i];
            words[i] = getSubstring(text, start, end);
            start = end + 1;
        }
        words[wordCount - 1] = getSubstring(text, start, length);
        return words;
    }

   
    public static String getSubstring(String str, int start, int end) {
        String result = "";
        for (int i = start; i < end; i++) {
            result += str.charAt(i);
        }
        return result;
    }


    public static String[][] getWordsWithLengths(String[] words) {
        int wordCount = getLengthWithoutUsingLengthMethod(words); 
        String[][] wordLengthArray = new String[wordCount][2];

        for (int i = 0; i < wordCount; i++) {
            int len = getLengthWithoutUsingLengthMethod(words[i]);
            wordLengthArray[i][0] = words[i];
            wordLengthArray[i][1] = String.valueOf(len); 
        }

        return wordLengthArray;
    }

    public static int getLengthWithoutUsingLengthMethod(String[] array) {
        int count = 0;
        try {
            while (true) {
                String temp = array[count];
                count++;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
          
        }
        return count;
    }


    public static void displayTable(String[][] wordLengthArray) {
        System.out.printf("%-15s | %-10s\n", "Word", "Length");
        System.out.println("---------------------------");

        int rows = getLengthWithoutUsingLengthMethod(wordLengthArray);
        for (int i = 0; i < rows; i++) {
            String word = wordLengthArray[i][0];
            int length = Integer.parseInt(wordLengthArray[i][1]); 
            System.out.printf("%-15s | %-10d\n", word, length);
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String input = scanner.nextLine();

        String[] words = customSplit(input);
        String[][] wordLengthArray = getWordsWithLengths(words);

        System.out.println("\nWord and Length Table:");
        displayTable(wordLengthArray);

        scanner.close();
    }
}
