class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int[] count = new int[nums.length + 1];
        count[0] = 1;
        int prefixSum = 0, result = 0;

        for (int num : nums) {
            prefixSum += num;
            if (prefixSum >= goal) result += count[prefixSum - goal];
            count[prefixSum]++;
        }

        return result;
    }
}