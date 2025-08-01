class Solution {
    public int maxProfit(int[] prices) {
        int stockPrice = prices[0];
        int profit = 0;

        for(int i = 1; i < prices.length; i++) {
            stockPrice = Math.min(prices[i], stockPrice);

            // as long as profit, sell it, and buy that stock on that day
            if (prices[i] - stockPrice > 0) {
                profit += prices[i] - stockPrice;
                stockPrice = prices[i];
            }
           
        }

        return profit;

        
    }
}