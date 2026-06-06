class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0, buy = prices[0], day = 1;

        while (day < prices.length) {
            if (prices[day] < buy) buy = prices[day];
            else profit = Math.max(profit, prices[day] - buy);
            day++;
        }

        return profit;
    }
}
