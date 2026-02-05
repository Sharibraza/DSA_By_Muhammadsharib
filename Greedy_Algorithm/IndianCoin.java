package Greedy_Algorithm;

import java.util.*;

public class IndianCoin {
    public static void main(String[] args) {
        Integer coins[] = {1,2,5,10,20,50,100,200,500,2000};
        ArrayList<Integer> change = new ArrayList<>();

        Arrays.sort(coins, Comparator.reverseOrder());

        int countOfCoins = 0;
        int amount = 590;

        for (int i = 0; i < coins.length; i++) {
            
            if ( coins[i] <= amount) {
                while (coins[i] <= amount) {
                    countOfCoins++;
                    change.add(coins[i]);
                    amount = amount - coins[i];
                }
            }
        }

        System.out.println("Min no. of coins to make change : " + countOfCoins + " \nChange : " + change);

    }
}
