package search;

public class BinarySearch {
    private int[] vet;

    public BinarySearch() {
        vet = new int[]{1,2,3,4,5,6,7,8,9,10};
    }

    public int pesqseq(int val) {
        return pesqseq(val, vet.length - 1);
    }

    private int pesqseq(int val, int n) {
        if (n < 0) return -1;
        if (vet[n] == val) return n;
        return pesqseq(val, n - 1);
    }

    public int pesqbin(int val) {
        int m;
        int L = 0;
        int R = vet.length - 1;

        while (L <= R) {
            m = L + (R - L) / 2;

            if (vet[m] == val) {
                return m;
            } else if (val > vet[m]) {
                L = m + 1;
            } else {
                R = m - 1;
            }
        }
        return -1;
    }

    public int pesqbinRec(int val) {
        return pesqbinRec(val, 0, vet.length - 1);
    }

    private int pesqbinRec(int val, int L, int R) {
        if (L > R) return -1;
        int m = L + (R - L) / 2;
        if (vet[m] == val) return m;
        if (val > vet[m]) return pesqbinRec(val, m +1, R);
        return pesqbinRec(val, L , m - 1);
    }

}
