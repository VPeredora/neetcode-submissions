class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int prev = -1, amount = nums.length;
        
        for (int i = 0; i < nums.length; i++) {
            if (prev == nums[i]) {amount--; continue;}
            if (amount > prev && nums[i] >= amount) return amount;

            prev = nums[i];
            amount--;
        }

        return -1;
    }
}