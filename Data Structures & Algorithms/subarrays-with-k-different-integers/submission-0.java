class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        Set<Integer> uniqueNums = new HashSet<>();
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                uniqueNums.add(nums[j]);
                if (uniqueNums.size() == k) result++;
                if (uniqueNums.size() > k) break;
            }
            uniqueNums.clear();
        }

        return result;
    }
}