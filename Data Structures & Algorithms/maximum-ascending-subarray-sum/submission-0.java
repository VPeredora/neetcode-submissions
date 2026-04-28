class Solution {
    public int maxAscendingSum(int[] nums) {
        int sum = 0, temp = 0;

        for (int i = 1; i < nums.length; i++) {
            temp = nums[i - 1];
            while (i < nums.length && nums[i] > nums[i - 1]) {
                temp += nums[i];
                i++;
            }
            sum = Math.max(sum, temp);
        }

        return sum;
    }
}