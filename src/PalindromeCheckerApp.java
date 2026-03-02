import java.util.*;

public class PalindromeCheckerApp {
    
    // UC1: Welcome Message
    public static void displayWelcomeMessage() {
        System.out.println("========================================");
        System.out.println("Welcome to the Palindrome Checker App");
        System.out.println("Version: 1.0");
        System.out.println("System initialized successfully.");
        System.out.println("========================================");
    }
    
    // UC2: Hardcoded Palindrome
    public static void checkHardcodedPalindrome() {
        String str = "madam";
        String reversed = "";
        
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += str.charAt(i);
        }
        
        if (str.equals(reversed)) {
            System.out.println("UC2 - Hardcoded String 'madam' is a palindrome!");
        } else {
            System.out.println("UC2 - Hardcoded String 'madam' is NOT a palindrome!");
        }
    }
    
    // UC3: String Reverse Method
    public static boolean isPalindromeReverse(String input) {
        String reversed = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed += input.charAt(i);
        }
        return input.equals(reversed);
    }
    
    // UC4: Character Array Method
    public static boolean isPalindromeCharArray(String input) {
        char[] chars = input.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        
        while (left < right) {
            if (chars[left] != chars[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    
    public static void main(String[] args) {
        // UC1: Display Welcome Message
        displayWelcomeMessage();
        
        // UC2: Check Hardcoded Palindrome
        System.out.println("\n--- UC2: Hardcoded Palindrome ---");
        checkHardcodedPalindrome();
        
        // Test strings
        String[] testStrings = {"madam", "radar", "civic", "refer", "hello"};
        
        // UC3: String Reverse Method
        System.out.println("\n--- UC3: String Reverse Method ---");
        for (String str : testStrings) {
            System.out.println("Input: " + str + " | Is Palindrome? " + isPalindromeReverse(str));
        }
        
        // UC4: Character Array Method
        System.out.println("\n--- UC4: Character Array Method ---");
        for (String str : testStrings) {
            System.out.println("Input: " + str + " | Is Palindrome? " + isPalindromeCharArray(str));
        }
    }
}
