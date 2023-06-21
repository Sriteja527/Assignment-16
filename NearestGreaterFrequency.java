import java.util.*;

public class NearestGreaterFrequency {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input array size
        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();
        
        // Input array elements
        System.out.println("Enter the array elements:");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        
        // Calculate the nearest greater frequency for each element
        int[] result = findNearestGreaterFrequency(arr);
        
        // Print the result
        System.out.println("Result:");
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i] + ": " + result[i]);
        }
    }
    
    public static int[] findNearestGreaterFrequency(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        Map<Integer, Integer> nextGreaterMap = new HashMap<>();
        
        for (int i = n - 1; i >= 0; i--) {
            int element = arr[i];
            int frequency = frequencyMap.getOrDefault(element, 0) + 1;
            frequencyMap.put(element, frequency);
            
            int nextGreaterFrequency = nextGreaterMap.getOrDefault(element, Integer.MAX_VALUE);
            nextGreaterMap.put(element, nextGreaterFrequency);
            
            if (frequencyMap.containsKey(element + 1)) {
                nextGreaterFrequency = Math.min(nextGreaterFrequency, frequencyMap.get(element + 1));
            }
            
            if (nextGreaterFrequency < Integer.MAX_VALUE) {
                result[i] = nextGreaterFrequency;
            } else {
                result[i] = -1;
            }
        }
        
        return result;
    }
}
