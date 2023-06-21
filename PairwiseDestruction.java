import java.util.*;

public class PairwiseDestruction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> words = new ArrayList<>();

        // Input sequence of words
        System.out.print("Enter the sequence of words (separated by spaces): ");
        String input = scanner.nextLine();

        // Split the input into individual words
        String[] wordArray = input.split(" ");
        words.addAll(Arrays.asList(wordArray));

        // Calculate the number of words left after pairwise destruction
        int remainingWords = calculateRemainingWords(words);

        // Print the result
        System.out.println("Number of words left after pairwise destruction: " + remainingWords);
    }

    public static int calculateRemainingWords(List<String> words) {
        Stack<String> stack = new Stack<>();

        for (String word : words) {
            if (stack.isEmpty()) {
                stack.push(word);
            } else {
                String top = stack.peek();

                if (top.equals(word)) {
                    stack.pop();
                } else {
                    stack.push(word);
                }
            }
        }

        return stack.size();
    }
}
