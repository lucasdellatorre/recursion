import list.List;
import recursion.Recursion;

public class Main {
    public static void main(String[] args) {
        List ld = new List();

        ld.insertSorted(11);
        ld.insertSorted(10);
        ld.insertSorted(9);
        ld.insertSorted(8);
        ld.insertSorted(3);
        ld.insertSorted(15);


        System.out.println(ld.delete(10));

        System.out.println(ld.min());

        ld.print();
    }
}