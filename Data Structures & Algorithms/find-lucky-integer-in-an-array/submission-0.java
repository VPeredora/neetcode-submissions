class Solution {
    public int findLucky(int[] arr) {
        Map<Integer, Integer> frequency = new HashMap<>();

        for (int i : arr)
            frequency.merge(i, 1, Integer::sum);

        return frequency.entrySet().stream()
               .filter(e -> e.getKey().equals(e.getValue()))
               .mapToInt(Map.Entry::getKey).max().orElse(-1);
    }
}