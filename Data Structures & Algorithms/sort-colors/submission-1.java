class Solution {
    public void sortColors(int[] nums) {
        int[] frequency = new int[3];
        for (int num : nums)
            frequency[num]++;
        
        int index = 0;
        for (int i = 0; i < 3; i++)
            while (frequency[i]-- > 0)
                nums[index++] = i;
    }
}
