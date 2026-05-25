class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int num : nums)
            frequency.merge(num, 1, Integer::sum);

        List<int[]> arr = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : frequency.entrySet())
            arr.add(new int[]{entry.getValue(), entry.getKey()});

        arr.sort((a, b) -> Integer.compare(b[0], a[0]));

        int[] result = new int[k];
        for (int i = 0; i < k; i++)
            result[i] = arr.get(i)[1];

        return result;
    }
}
