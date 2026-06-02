class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numbers = new HashSet<>(nums.length);
        for (int num : nums)
            numbers.add(num);
        
        int result = 0;
        for (int num : nums) {
            int number = num;
            int sequence = 1;

            while (numbers.contains(++number)) sequence++;
            result = Math.max(result, sequence);
        }

        return result;
    }
}
