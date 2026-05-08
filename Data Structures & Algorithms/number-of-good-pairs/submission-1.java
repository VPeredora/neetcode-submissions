class Solution {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> frequency = new HashMap<>();
        int goodPairs = 0;

        for (int num : nums) {
            goodPairs += frequency.getOrDefault(num, 0);
            frequency.merge(num, 1, Integer::sum);
        }

        return goodPairs;
    }
}