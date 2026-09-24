class Solution {
    public int longestOnes(int[] nums, int k) {
        int[] prefix = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++)
            if (nums[i] == 0) prefix[i + 1] = prefix[i] + 1;
            else prefix[i + 1] = prefix[i];

        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int l = i, r = nums.length;

            while (l < r) {
                int mid = l + (r - l) / 2;
                if (prefix[mid + 1] - prefix[i] <= k) l = mid + 1;
                else r = mid;
            }

            result = Math.max(result, r - i);
        }

        return result;
    }
}