class Solution {
    public int subarraySum(int[] nums, int k) {
        int result = 0, sum = 0;
        Map<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0, 1);

        for (int num : nums) {
            sum += num;
            int diff = sum - k;
            result += prefixSum.getOrDefault(diff, 0);
            prefixSum.merge(sum, 1, Integer::sum);
        }

        return result;
    }
}