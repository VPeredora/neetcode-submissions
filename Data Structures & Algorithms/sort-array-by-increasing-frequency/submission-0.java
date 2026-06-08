class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int num : nums)
            frequency.merge(num, 1, Integer::sum);
        
        Integer[] numbers = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        
        Arrays.sort(numbers, (a, b) -> {
            int frequencyA = frequency.get(a), frequencyB = frequency.get(b);
            if (frequencyA == frequencyB) return Integer.compare(b, a);
            return Integer.compare(frequencyA, frequencyB);
        });

        return Arrays.stream(numbers).mapToInt(Integer::intValue).toArray();
    }
}
