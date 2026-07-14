class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int n : nums)
            frequency.merge(n, 1, Integer::sum);
        
        int threshold = nums.length / 3;
        List<Integer> result = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : frequency.entrySet())
            if (entry.getValue() > threshold) result.add(entry.getKey());

        return result;
    }
}