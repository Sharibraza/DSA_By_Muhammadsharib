package Greedy_Algorithm;

import java.util.Arrays;
import java.util.Comparator;

public class Fractional_Knapsack {
  public static void fractionalKnapsack(int[] value, int[] weight, int capacity) {
       
        double ratio[][] = new double[value.length][2];

        for (int i = 0; i < ratio.length; i++) {
            ratio[i][0] = i;
            ratio[i][1] = value[i] / (double) weight[i];
        }

        // Ascending order
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

         int maxVal = 0;

        // To get in Descending order [ backward looping ]
        for (int i = ratio.length-1 ; i >= 0 ; i--) {
            int idx = (int)ratio[i][0];
            if (capacity >= weight[idx]) {   // include full item
                capacity = capacity - weight[idx];
                maxVal += value[idx];
            } else {
                // include fractional item
                maxVal += (ratio[i][1] * capacity);
                capacity = 0;
                break;
            }
        }

        System.out.println("Max Val = " + maxVal);
    }

    public static void main(String[] args) {

        int value[] = { 60, 100, 120 };
        int weight[] = { 10, 20, 30 };
        int capacity = 50;

        fractionalKnapsack(value, weight, capacity);

    }   
}
