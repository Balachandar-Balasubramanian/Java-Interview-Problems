import java.util.HashMap;

public class MinNumOfSquare {
    static HashMap<Integer, Integer> memory = new HashMap<>();

    public static int minSquare(int n) {
        if (n == 0 || n == 1 || n == 2 || n == 3) {
            return n;
        }

        if (memory.containsKey(n)) {
            return memory.get(n);
        }

        int value = n; // Initialize with the maximum possible value
        for (int i = 1; i * i <= n; i++) {
            int x = n - (i * i);
            value = Math.min(value, minSquare(x) + 1);
        }

        memory.put(n, value);
        return value;
    }

    public static void main(String[] args) {
        int n = 1024;
        System.out.println(minSquare(n)); // Output: 3
    }
}
