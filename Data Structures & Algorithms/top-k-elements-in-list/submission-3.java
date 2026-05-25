class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int num : nums)
            frequency.merge(num, 1, Integer::sum);
        
        List<Integer>[] buckets = new List[nums.length + 1];
        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            int count = entry.getValue();
            if (buckets[count] == null) buckets[count] = new ArrayList<>();
            buckets[count].add(entry.getKey());
        }

        System.out.println(Arrays.toString(buckets));

        int[] result = new int[k];
        int index = 0;
        for (int i = buckets.length - 1; i > 0 && index < k; i--) {
            if (buckets[i] != null) {
                for (int num : buckets[i]) {
                   result[index++] = num;
                   if (index == k) return result;
                }
            }
        }
        
        return result;
    }
}
