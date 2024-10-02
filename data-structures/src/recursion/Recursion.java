package recursion;

import java.util.ArrayList;
import java.util.List;

public class Recursion {
    public static int peasantMultiply(int x, int y) {
        if (x == 0) return 0;
        x = x / 2;
        y = y + y;
        System.out.println("x: " + x);
        System.out.println("y: " + y);
        int prod = peasantMultiply(x, y);
        if (x % 2 != 0) {
            prod = prod + y;
        }
        System.out.println("prod: " + prod);
        return prod;
    }

    public static int power(int base, int exp) {
        if (exp == 0) return 1;
        return base * power(base, exp - 1);
    }

    public static boolean isListSorted(List<Integer> arr) {
        int n = arr.size();
        if (n <= 1) {
            return true;
        }
        return (isListSorted(arr.subList(0, n / 2))) && arr.get(n / 2 - 1) <= arr.get(n / 2) && isListSorted(arr.subList(n / 2, n));
    }
}
