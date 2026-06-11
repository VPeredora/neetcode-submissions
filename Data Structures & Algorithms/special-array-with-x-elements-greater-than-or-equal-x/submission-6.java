class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int prev = -1;
        
        for (int i = 0; i < nums.length; i++) {
            if (prev == nums[i]) continue;

            int amount = nums.length - i;
            if (amount > prev && nums[i] >= amount) return amount;
            
            prev = nums[i];
        }

        return -1;
    }
}