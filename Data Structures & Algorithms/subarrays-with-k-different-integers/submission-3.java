class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }

    private int atMostK(int[] nums, int k) {
        Map<Integer, Integer> window = new HashMap<>();
        int result = 0;

        for (int l = 0, r = 0; r < nums.length; r++) {
            window.merge(nums[r], 1, Integer::sum);
            if (window.get(nums[r]) == 1) k--;
            
            while (k < 0) {
                window.merge(nums[l], -1, Integer::sum);
                if (window.get(nums[l++]) == 0) k++;
            }

            result += r - l + 1;
        }
 
        return result;
    }
}