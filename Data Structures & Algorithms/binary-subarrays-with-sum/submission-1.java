class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> count = new HashMap<>();
        count.put(0, 1);
        int prefixSum = 0, result = 0;

        for (int num : nums) {
            prefixSum += num;
            result += count.getOrDefault(prefixSum - goal, 0);
            count.merge(prefixSum, 1, Integer::sum);
        }

        return result;
    }
}