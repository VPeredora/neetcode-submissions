class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int i : nums)
            frequency.merge(i, 1, Integer::sum);
            
        return frequency.entrySet().stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(1)
            .mapToInt(Map.Entry::getKey).findFirst().getAsInt();
    }
}