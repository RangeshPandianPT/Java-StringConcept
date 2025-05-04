import java.util.Scanner;

public class PalindromeCheck {

    
    public static boolean isPalindromeUsingIndexes(String text) {
        int start = 0;
        int end = text.length() - 1;

        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    
    public static boolean isPalindromeRecursively(String text, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (text.charAt(start) != text.charAt(end)) {
            return false;
        }
        return isPalindromeRecursively(text, start + 1, end - 1);
    }

    
    public static boolean isPalindromeUsingReverse(String text) {
        char[] originalArray = text.toCharArray();
        char[] reversedArray = new char[text.length()];

        
        for (int i = 0; i < text.length(); i++) {
            reversedArray[i] = originalArray[text.length() - 1 - i];
        }

        
        for (int i = 0; i < text.length(); i++) {
            if (originalArray[i] != reversedArray[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string to check if it's a palindrome: ");
        String inputText = scanner.nextLine();

        
        boolean resultUsingIndexes = isPalindromeUsingIndexes(inputText);
        boolean resultUsingRecursion = isPalindromeRecursively(inputText, 0, inputText.length() - 1);
        boolean resultUsingReverse = isPalindromeUsingReverse(inputText);

        
        System.out.println("Palindrome check using indexes: " + resultUsingIndexes);
        System.out.println("Palindrome check using recursion: " + resultUsingRecursion);
