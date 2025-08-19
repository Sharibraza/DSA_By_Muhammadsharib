package ArrayList;

import java.util.ArrayList;

public class PairSum1 {
    public static boolean pairsum(ArrayList<Integer> arr, int target) {

        int lp = 0;
        int rp = arr.size() - 1;

        while (lp != rp) { // single ka sum X

            if (arr.get(lp) + arr.get(rp) == target) {
                return true;
            }

            if (arr.get(lp) + arr.get(rp) < target) {
                lp++;
            } else {
                rp--;
            }

        }
        return false;

    }

    public static void main(String[] args) {

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(8);
        arr.add(6);
        arr.add(2);

        int target = 10;

        System.out.println(pairsum(arr, target));

    }
}
