class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> numbers = new HashMap<>();
        int result = 0;

        for (int num : nums) {
            if (numbers.containsKey(num)) continue;
            
            int left = numbers.getOrDefault(num - 1, 0);
            int right = numbers.getOrDefault(num + 1, 0);
            int sequence = left + right + 1;

            numbers.put(num, sequence);

            numbers.put(num - left, sequence);
            numbers.put(num + right, sequence);

            result = Math.max(result, sequence);
        }

        return result;
    }
}
