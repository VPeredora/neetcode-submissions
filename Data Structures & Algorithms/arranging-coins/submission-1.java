class Solution {
    public int arrangeCoins(int n) {
        int k = 0;

        while (true) {
            n -= (k + 1);
            if (n >= 0) k++;
            else return k;
        }
    }
}