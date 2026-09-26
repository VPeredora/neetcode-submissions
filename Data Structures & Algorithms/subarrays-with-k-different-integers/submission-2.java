class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }

    private int atMostK(int[] nums, int k) {
        Map<Integer, Integer> subarray = new HashMap<>();
        int result = 0;

        for (int l = 0, r = 0; r < nums.length; r++) {
            subarray.merge(nums[r], 1, Integer::sum);

            while (subarray.size() > k) {
                int leftNum = nums[l++];
                subarray.merge(leftNum, -1, Integer::sum);
                if (subarray.get(leftNum) == 0) subarray.remove(leftNum);
            }

            result += r - l + 1;
        }

        return result;
    }
}