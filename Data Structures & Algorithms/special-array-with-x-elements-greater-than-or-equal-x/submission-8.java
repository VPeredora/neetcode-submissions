class Solution {
    public int specialArray(int[] nums) {
        int[] count = new int[nums.length + 1];
        for (int num : nums) {
            int index = Math.min(num, nums.length);
            count[index]++;
        }
        
        int amount = 0;
        for (int i = nums.length; i >= 0; i--) {
            amount += count[i];
            if (i == amount) return amount;
        }
        return -1;
    }
}