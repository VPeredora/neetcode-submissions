class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0, sum = 0, length = nums.length + 1;

        for (int r = 0; r < nums.length; r++) {
            sum += nums[r];

            while (sum >= target) {
                length = Math.min(length, r - l + 1);
                sum -= nums[l++];
                System.out.println(length);
            }
        }

        return length == nums.length + 1 ? 0 : length;
    }
}