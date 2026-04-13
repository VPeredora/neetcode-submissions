class Solution {
    public int maxProfit(int[] prices) {
        int buy = prices[0], sell = 0, temp = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < temp) temp = prices[i];
            if (prices[i] == sell && temp < buy) buy = temp;
            if (prices[i] > temp && sell - buy < prices[i] - temp) {
                sell = prices[i];
                buy = temp;
            }
        }
        return buy < sell ? sell - buy : 0;
    }
}
