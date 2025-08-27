package Greedy_Algorithm;

import java.util.Arrays;
import java.util.Collections;

public class Chocola {
    public static void chocolaProblem() {

        int n = 4, m = 6;
        Integer costVer[] = { 2, 1, 3, 1, 4 }; //m-1
        Integer costHor[] = { 4, 1, 2 };    // n-1

        // Descending order
        Arrays.sort(costVer, Collections.reverseOrder());   
        Arrays.sort(costHor, Collections.reverseOrder());

        int h = 0, v = 0;
        int hp = 1, vp = 1; // Horizontal and Vertical peices
        int cost = 0;

        while (h < costHor.length && v < costVer.length) {

            if (costVer[v] <= costHor[h]) {
                cost += (costHor[h] * vp); // Horizontal cut
                h++;
                hp++;
            } else { // Vertical cut
                cost += (costVer[v] * hp);
                v++;
                vp++;
            }
        }

        while (h < costHor.length) {    // for rest of Horizontal cuts
            cost += (costHor[h] * vp);
            h++;
            hp++;
        }

        while (v < costVer.length) {    // for rest of Vertical cuts
            cost += (costVer[v] * hp);
            v++;
            vp++;
        }

        System.out.println("Min cost of cuts = " + cost);
    }

    public static void main(String[] args) {

        chocolaProblem();

    }
}
