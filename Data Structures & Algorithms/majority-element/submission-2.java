class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int i : nums)
            frequency.merge(i, 1, Integer::sum);
            
        return frequency.entrySet().stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .findFirst().get().getKey().intValue();
    }
}