class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0, day = 0, buy = prices[0];

        while (++day < prices.length)
            if (prices[day] <= buy) buy = prices[day];
            else {
                profit += prices[day] - buy;
                buy = prices[day];
            }

        return profit;
    }
}