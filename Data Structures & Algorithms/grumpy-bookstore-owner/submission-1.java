class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int maximum = 0, maxWindow = 0;
        int l = 0, cur = 0;

        for (int r = 0; r < customers.length; r++) {
            if (grumpy[r] == 1) cur += customers[r];
            else maximum += customers[r];

            if (r - l + 1 > minutes) {
                if (grumpy[l] == 1) cur -= customers[l];
                l++;
            }
                
            maxWindow = Math.max(maxWindow, cur);
        }
        
        return maximum + maxWindow;
    }
}