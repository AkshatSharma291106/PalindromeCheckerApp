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
    
    // UC5: Stack Method
    public static boolean isPalindromeStack(String input) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }
        
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != stack.pop()) {
                return false;
            }
        }
        return true;
    }
    
    // UC6: Queue + Stack Method
    public static boolean isPalindromeQueueStack(String input) {
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            queue.add(c);
            stack.push(c);
        }
        
        while (!queue.isEmpty()) {
            if (!queue.remove().equals(stack.pop())) {
                return false;
            }
        }
        return true;
    }
    
    // UC7: Deque Method
    public static boolean isPalindromeDeque(String input) {
        Deque<Character> deque = new LinkedList<>();
        
        for (int i = 0; i < input.length(); i++) {
            deque.addLast(input.charAt(i));
        }
        
        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false;
            }
        }
        return true;
    }
    
    // UC8: Linked List Method
    static class ListNode {
        char val;
        ListNode next;
        ListNode(char val) { this.val = val; }
    }
    
    public static boolean isPalindromeLinkedList(String input) {
        // Create linked list
        ListNode head = null;
        ListNode tail = null;
        for (int i = 0; i < input.length(); i++) {
            ListNode newNode = new ListNode(input.charAt(i));
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }
        
        // Find middle using fast/slow pointer
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Reverse second half
        ListNode prev = null;
        ListNode curr = slow;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        // Compare first and second half
        ListNode left = head;
        ListNode right = prev;
        while (right != null) {
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }
    
    // UC9: Recursive Method
    public static boolean isPalindromeRecursive(String input, int left, int right) {
        if (left >= right) {
            return true;
        }
        if (input.charAt(left) != input.charAt(right)) {
            return false;
        }
        return isPalindromeRecursive(input, left + 1, right - 1);
    }
    
    // UC10: Case-Insensitive & Space-Ignored
    public static boolean isPalindromeIgnoreCaseSpace(String input) {
        String cleaned = input.replaceAll("\\s+", "").toLowerCase();
        return isPalindromeRecursive(cleaned, 0, cleaned.length() - 1);
    }
    
    // UC11: Object-Oriented Service
    static class PalindromeService {
        private String input;
        
        public PalindromeService(String input) {
            this.input = input;
        }
        
        public boolean checkWithReverse() {
            return isPalindromeReverse(input);
        }
        
        public boolean checkWithCharArray() {
            return isPalindromeCharArray(input);
        }
        
        public boolean checkWithStack() {
            return isPalindromeStack(input);
        }
        
        public boolean checkWithDeque() {
            return isPalindromeDeque(input);
        }
        
        public void printResults() {
            System.out.println("Palindrome check results for: '" + input + "'");
            System.out.println("  Reverse Method: " + checkWithReverse());
            System.out.println("  CharArray Method: " + checkWithCharArray());
            System.out.println("  Stack Method: " + checkWithStack());
            System.out.println("  Deque Method: " + checkWithDeque());
        }
    }
    
    public static void main(String[] args) {
        // UC1: Display Welcome Message
        displayWelcomeMessage();
        
        // UC2: Check Hardcoded Palindrome
        System.out.println("\n--- UC2: Hardcoded Palindrome ---");
        checkHardcodedPalindrome();
        
        // Test strings
        String[] testStrings = {"madam", "radar", "civic", "refer", "level", "hello"};
        String[] testStringsWithSpace = {"A man a plan a canal Panama", "Was it a car or a cat I saw", "hello world"};
        
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
        
        // UC5: Stack Method
        System.out.println("\n--- UC5: Stack Method ---");
        for (String str : testStrings) {
            System.out.println("Input: " + str + " | Is Palindrome? " + isPalindromeStack(str));
        }
        
        // UC6: Queue + Stack Method
        System.out.println("\n--- UC6: Queue + Stack Method ---");
        for (String str : testStrings) {
            System.out.println("Input: " + str + " | Is Palindrome? " + isPalindromeQueueStack(str));
        }
        
        // UC7: Deque Method
        System.out.println("\n--- UC7: Deque Method ---");
        for (String str : testStrings) {
            System.out.println("Input: " + str + " | Is Palindrome? " + isPalindromeDeque(str));
        }
        
        // UC8: Linked List Method
        System.out.println("\n--- UC8: Linked List Method ---");
        for (String str : testStrings) {
            System.out.println("Input: " + str + " | Is Palindrome? " + isPalindromeLinkedList(str));
        }
        
        // UC9: Recursive Method
        System.out.println("\n--- UC9: Recursive Method ---");
        for (String str : testStrings) {
            System.out.println("Input: " + str + " | Is Palindrome? " + 
                isPalindromeRecursive(str, 0, str.length() - 1));
        }
        
        // UC10: Case-Insensitive & Space-Ignored
        System.out.println("\n--- UC10: Case-Insensitive & Space-Ignored ---");
        for (String str : testStringsWithSpace) {
            System.out.println("Input: '" + str + "' | Is Palindrome? " + isPalindromeIgnoreCaseSpace(str));
        }
        
        // UC11: Object-Oriented Service
        System.out.println("\n--- UC11: Object-Oriented Service ---");
        PalindromeService service = new PalindromeService("radar");
        service.printResults();
    }
}
