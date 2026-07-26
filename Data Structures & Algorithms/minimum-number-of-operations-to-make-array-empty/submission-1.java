class Solution {
    public int minOperations(int[] nums) {
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int num : nums)
            frequency.merge(num, 1, Integer::sum);
        
        int operations = 0;
        for (Integer amount : frequency.values())
            if (amount == 1) return -1;
            else operations += (amount + 2) / 3;

        return operations;
    }
}