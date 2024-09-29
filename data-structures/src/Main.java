import list.List;
import recursion.Recursion;

public class Main {
    public static void main(String[] args) {
        List ld = new List();

        ld.insertSorted(11);
        ld.insertSorted(10);
        ld.insertSorted(9);

        System.out.println(ld.exist(1));
        ld.print();
    }
}