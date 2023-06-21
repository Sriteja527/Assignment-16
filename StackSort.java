import java.util.*;

public class StackSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();

        // Input stack size
        System.out.print("Enter the size of the stack: ");
        int n = scanner.nextInt();

        // Input stack elements
        System.out.println("Enter the stack elements:");
        for (int i = 0; i < n; i++) {
            stack.push(scanner.nextInt());
        }

        // Sort the stack
        Stack<Integer> sortedStack = sortStack(stack);

        // Print the sorted stack
        System.out.println("Sorted stack:");
        while (!sortedStack.isEmpty()) {
            System.out.println(sortedStack.pop());
        }
    }

    public static Stack<Integer> sortStack(Stack<Integer> stack) {
        Stack<Integer> tempStack = new Stack<>();

        while (!stack.isEmpty()) {
            int temp = stack.pop();

            while (!tempStack.isEmpty() && tempStack.peek() > temp) {
                stack.push(tempStack.pop());
            }

            tempStack.push(temp);
        }

        return tempStack;
    }
}
