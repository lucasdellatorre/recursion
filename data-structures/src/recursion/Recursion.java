package recursion;

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
}
