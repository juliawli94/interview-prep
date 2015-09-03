import java.util.HashMap;

interface TwoSumInterface {

    /**
     * Stores @param input in an internal data structure.
     */
    void store(int input);

 
    /**
     * Returns true if there is any pair of numbers in the internal data structure which
     * have sum @param val, and false otherwise.
     * For example, if the numbers 1, -2, 3, and 6 had been stored,
     * the method should return true for 4, -1, and 9, but false for 10, 5, and 0
     */
    boolean test(int val);
}

public class TwoSumLinkedIn {

    static HashMap<Integer, Integer> history = new HashMap<Integer, Integer>();
    
    public static void store(int input) {
        if (history.containsKey(input)) {
            history.put(input, history.get(input) + 1);
        } else {
            history.put(input, 1);
        }
    }
    
    public static boolean test(int val) {
        for (int i : history.keySet()) {
            if (history.containsKey(val - i)) {
                if (val - i == i) return (history.get(val-i) > 1);
                else return true;
            }
        }
        return false;
    }

    public static void clean() {
        history.clear();
    }

    public static void main(String[] args) {
        System.out.println("Storing 1, -2, 3, 6");
        store(1);
        store(-2);
        store(3);
        store(6);
        System.out.println(String.format("History map should be size 4: %s", history.size()));
        System.out.println("Expecting true");
        System.out.println(test(4));
        System.out.println(test(-1));
        System.out.println(test(9));
        System.out.println("Expecting false");
        System.out.println(test(10));
        System.out.println(test(5));
        System.out.println(test(0));
        System.out.println("Clearing history map");
        clean();
        System.out.println(String.format("History map should be size 0: %s", history.size()));
        System.out.println("Storing 10");
        store(10);
        System.out.println(String.format("Testing 20, expecting false: %s", test(20)));
        System.out.println("Storing another 10");
        store(10);
        System.out.println(String.format("Testing 20, expecting true: %s", test(20)));
    }

// store(10)
// store(10)
// test(20) => true
}
