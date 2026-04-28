class Solution {
    public int maxAscendingSum(int[] nums) {
        int sum = nums[0], temp = nums[0];

        for (int i = 1; i < nums.length; i++) {
           if (nums[i] <= nums[i - 1]) temp = 0;
           temp += nums[i];
           sum = Math.max(sum, temp);
        }

        return sum;
    }
}