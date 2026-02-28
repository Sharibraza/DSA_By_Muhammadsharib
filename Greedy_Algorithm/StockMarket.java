package Greedy_Algorithm;

public class StockMarket {

    public static int stockMarket(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int buyPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (buyPrice > prices[i]) {  // profit
                buyPrice = prices[i];
            } else if (prices[i] - buyPrice > maxProfit) {
                maxProfit = prices[i] - buyPrice;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {

        int prices[] = {7, 1, 5, 3, 6, 4};

        // needs to be correct
        System.out.println(stockMarket(prices));

    }
}
