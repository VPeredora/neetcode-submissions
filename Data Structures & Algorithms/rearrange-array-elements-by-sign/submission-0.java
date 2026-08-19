class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] positive = new int[nums.length / 2];
        int[] negative = new int[nums.length / 2];

        for (int i = 0, j = 0; i < nums.length; i++)
            if (nums[i] >= 0) positive[j++] = nums[i];
        
        for (int i = 0, j = 0; i < nums.length; i++)
            if (nums[i] < 0) negative[j++] = nums[i];

        for (int i = 0, p = 0, n = 0; i < nums.length; i++)
            if ((i & 1) == 0) nums[i] = positive[p++];
            else nums[i] = negative[n++];

        return nums;
    }
}