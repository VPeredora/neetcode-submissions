class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numbers = new HashSet<>();
        for (int num : nums)
            numbers.add(num);
        
        int result = 0;
        for (int num : numbers) {
            if (!numbers.contains(num - 1)) {
                int sequence = 1;
                while (numbers.contains(++num)) sequence++;
                result = Math.max(result, sequence);
            }
        }

        return result;
    }
}
