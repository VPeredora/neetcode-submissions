class Solution {
    public int pivotIndex(int[] nums) {
        int sumL = 0, sumR = 0, pivotIndex = 0;
        for (int i = 1; i < nums.length; i++)
            sumR += nums[i];
        
        for (int i = 0; i < nums.length; i++) {
            if (sumL == sumR) return pivotIndex;
            if (i == nums.length - 1) break;
            sumR -= nums[i + 1];
            sumL += nums[i];
            System.out.println(sumL + " | " + sumR);
            pivotIndex++;
        }

        return -1;
    }
}