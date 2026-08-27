class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int maximum = 0;
        
        for (int i = 0; i < customers.length; i++)
            if (grumpy[i] == 0) maximum += customers[i];
        
        int satisfied = maximum;
        for (int i = 0; i <= customers.length - minutes; i++) {
            int cur = 0;

            for (int j = i; j < i + minutes; j++)
                if (grumpy[j] == 1) cur += customers[j];
                
            maximum = Math.max(maximum, satisfied + cur);
        }

        return maximum;
    }
}