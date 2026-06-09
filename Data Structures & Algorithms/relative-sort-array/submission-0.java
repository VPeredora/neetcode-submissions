class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> ordering = new HashMap<>();
        for (int i = 0; i < arr2.length; i++)
            ordering.put(arr2[i], i);

        Integer[] numbers = Arrays.stream(arr1).boxed().toArray(Integer[]::new);
        
        Arrays.sort(numbers, (a, b) -> {
            int indexA = ordering.getOrDefault(a, -1);
            int indexB = ordering.getOrDefault(b, -1);

            if (indexA >= 0 && indexB >= 0) return Integer.compare(indexA, indexB);
            if (indexA >= 0 && indexB == -1) return -1;
            if (indexA == -1 && indexB >= 0) return 1;
            return Integer.compare(a, b);
        });
        
        return Arrays.stream(numbers).mapToInt(Integer::intValue).toArray();
    }
}