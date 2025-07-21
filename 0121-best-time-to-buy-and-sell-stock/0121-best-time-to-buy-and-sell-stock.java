class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = Integer.MIN_VALUE;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            }

            maxProfit = Math.max(maxProfit, price - minPrice);

        }

        return maxProfit;
        
        
    }
}