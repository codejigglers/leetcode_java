package code;

public class Bloomberg {

    public static void main(String[] args) {
        System.out.println((Integer.parseInt("214748374") ));


    }


    static boolean isPalindrome(int integer) {
        int palindrome = integer;
        int reverse = 0;

        // Compute the reverse
        while (palindrome != 0) {
            int remainder = palindrome % 10;
            reverse = reverse * 10 + remainder;
            palindrome = palindrome / 10;
        }

        // The integer is palindrome if integer and reverse are equal
        return integer == reverse; // Improved by Peter Lawrey

    }
}
