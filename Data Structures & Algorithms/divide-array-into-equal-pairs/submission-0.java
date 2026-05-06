class Solution {
    public boolean divideArray(int[] nums) {
        Map<Integer, Integer> amount = new HashMap<>();

        for (int i = 0; i < nums.length; i++)
            amount.merge(nums[i], 1, Integer::sum);

        for (Integer value : amount.values())
            if (value % 2 != 0) return false;

        return true;
    }
}