class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> candidates = new HashMap<>();

        for (int num : nums) { 
            candidates.merge(num, 1, Integer::sum);

            if (candidates.size() > 2) {
                candidates.replaceAll((key, value) -> value - 1);
                candidates.values().removeIf(value -> value <= 0);
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int key : candidates.keySet()) {
            int frequency = 0;
            for (int num : nums)
                if (key == num) frequency++;
            if (frequency > nums.length / 3) result.add(key);
        }

        return result;
    }
}