class Solution {
    public int maxProfit(int[] prices) {
        int[][] table = new int[prices.length][2];

        for (int i = 0; i < prices.length; i++) {
            table[i][0] = -1;
            table[i][1] = -1;
        }

        return trade(prices, 0, 0, table);
    }

    private int trade(int[] prices, int i, int bought, int[][] table) {
        if (i == prices.length) return 0;
        if (table[i][bought] != - 1) return table[i][bought]; 

        int profit = trade(prices, i + 1, bought, table);

        if (bought == 1) profit = Math.max(profit, prices[i] + trade(prices, i + 1, 0, table));
        else profit = Math.max(profit, -prices[i] + trade(prices, i + 1, 1, table));

        table[i][bought] = profit;

        return profit;
    }
}