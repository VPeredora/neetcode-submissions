class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int[] count = new int[nums.length + 1];
        int l = 0, cnt = 0, result = 0;

        for (int r = 0; r < nums.length; r++) {
            count[nums[r]]++;
            if (count[nums[r]] == 1) k--;

            if (k < 0) {
                count[nums[l++]]--;
                k++;
                cnt = 0;
            }

            if (k == 0) {
                while (count[nums[l]] > 1) {
                    count[nums[l++]]--;
                    cnt++;
                }
                result += cnt + 1;
            }
        }

        return result;
    }
}