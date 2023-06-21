import java.util.*;

public class ReverseNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the number
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        // Reverse the number
        int reversedNumber = reverseNumber(number);

        // Print the reversed number
        System.out.println("Reversed number: " + reversedNumber);
    }

    public static int reverseNumber(int number) {
        Stack<Integer> stack = new Stack<>();

        // Push each digit of the number into the stack
        while (number > 0) {
            int digit = number % 10;
            stack.push(digit);
            number /= 10;
        }

        // Reconstruct the reversed number from the stack
        int reversedNumber = 0;
        int multiplier = 1;

        while (!stack.isEmpty()) {
            int digit = stack.pop();
            reversedNumber += digit * multiplier;
            multiplier *= 10;
        }

        return reversedNumber;
    }
}
