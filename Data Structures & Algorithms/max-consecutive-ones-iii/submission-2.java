class Solution {
    public int longestOnes(int[] nums, int k) {
        int l = 0, r = 0, zeros = 0;

        for (; r < nums.length; r++) {
            if (nums[r] == 0) zeros++;
            if (zeros > k && nums[l++] == 0) zeros--;
        }

        return r - l;
    }
}