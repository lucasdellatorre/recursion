import list.List;
import recursion.Recursion;

public class Main {
    public static void main(String[] args) {
        List ld = new List();


        ld.fill(10);
        ld.insert(3);

        ld.print();

        System.out.println(ld.kill(1));

        ld.print();
    }
}