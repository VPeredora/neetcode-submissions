class Solution {
    public void sortColors(int[] nums) {
        int[] frequency = new int[3];
        for (int num : nums)
            frequency[num]++;
        
        int color = 0;
        for (int i = 0; i < nums.length; i++) {
            while (color < frequency.length && frequency[color] <= 0) color++;
            frequency[color]--;
            nums[i] = color;
        }
    }
}