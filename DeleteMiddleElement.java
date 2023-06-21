import java.util.*;

public class DeleteMiddleElement {
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

        // Delete the middle element
        deleteMiddleElement(stack);

        // Print the modified stack
        System.out.println("Modified stack:");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    public static void deleteMiddleElement(Stack<Integer> stack) {
        int size = stack.size();
        int middle = size / 2;

        if (size % 2 == 0) {
            // Even number of elements, delete the lower middle element
            deleteMiddle(stack, middle - 1);
        } else {
            // Odd number of elements, delete the middle element
            deleteMiddle(stack, middle);
        }
    }

    public static void deleteMiddle(Stack<Integer> stack, int middle) {
        if (middle == 0) {
            // Base case: remove the top element
            stack.pop();
            return;
        }

        int temp = stack.pop();

        // Recursive call
        deleteMiddle(stack, middle - 1);

        // Push the popped elements back, except the middle element
        stack.push(temp);
    }
}
