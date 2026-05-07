class Solution {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> frequency = new HashMap<>();

        for (int num : nums)
            frequency.merge(num, 1, Integer::sum);

        return frequency.values().stream()
               .mapToInt(v -> (v * (v - 1)) / 2).sum();
    }
}
