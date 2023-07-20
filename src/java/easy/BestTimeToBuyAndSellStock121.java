package easy;

public class BestTimeToBuyAndSellStock121 {
    public int maxProfit(int[] prices) {
        int maxProfit = 0, buy = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if(prices[i] - buy > maxProfit)
                maxProfit = prices[i] - buy;
            else if(prices[i] < buy)
                buy = prices[i];
        }
        return maxProfit;
    }
}
