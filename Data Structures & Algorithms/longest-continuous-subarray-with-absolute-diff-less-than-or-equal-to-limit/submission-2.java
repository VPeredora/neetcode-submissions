class Solution {
    public int longestSubarray(int[] nums, int limit) {
        TreeMap<Integer, Integer> dict = new TreeMap<>();
        int result = 1;

        for (int l = 0, r = 0; r < nums.length; r++) {
            dict.merge(nums[r], 1, Integer::sum);

            while (dict.lastKey() - dict.firstKey() > limit) {
                dict.merge(nums[l], -1, Integer::sum);
                if (dict.get(nums[l]) == 0) dict.remove(nums[l]);
                l++;
            }

            result = Math.max(result, r - l + 1);
        }

        return result;
    }
}