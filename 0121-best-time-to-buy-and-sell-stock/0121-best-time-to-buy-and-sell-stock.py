class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        maxProfit = 0
        minBuy = 10 * 10 * 10000

        for num in prices:
            minBuy = min(num, minBuy)
            maxProfit = max(maxProfit, num - minBuy)

        return maxProfit    
