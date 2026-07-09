class Solution {
    public int maxProfit(int[] prices) {
        int[][] table = new int[prices.length + 1][2];

        for (int i = prices.length - 1; i >= 0; i--) {
            table[i][0] = Math.max(table[i + 1][0], -prices[i] + table[i + 1][1]);
            table[i][1] = Math.max(table[i + 1][1], prices[i] + table[i + 1][0]);
        }

        return table[0][0];
    }
}