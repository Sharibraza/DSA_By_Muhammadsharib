package ArrayList;

import java.util.ArrayList;

public class Pairsum2 {
    public static boolean pairsum2(ArrayList<Integer> arr, int target) {

        int bp = -1;
        int n = arr.size();

        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) > arr.get(i + 1)) {
                bp = i;
                break;
            }
        }

        int lp = bp + 1;
        int rp = bp;

        while (lp != rp) {

            if (arr.get(lp) + arr.get(rp) == target) {
                return true;
            }

            if (arr.get(lp) + arr.get(rp) < target) {
                lp = (lp + 1) % n; // if lp=n (%) --> end se turn
            } else { // 0 <--
                rp = (n - 1 + rp - 1) % n; // <-- start 0 se turn
            } // ---> n
        }
        return false;
    }

    public static void main(String[] args) {

        ArrayList<Integer> arr = new ArrayList<>(); // Sorted & Rotated
        arr.add(6);
        arr.add(8);
        arr.add(1);
        arr.add(2);

        int target = 10;

        System.out.println(pairsum2(arr, target));

    }
}
