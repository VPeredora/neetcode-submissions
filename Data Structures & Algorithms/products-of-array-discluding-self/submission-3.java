class Solution {
    public int[] productExceptSelf(int[] nums) {
        int multi = 1, oneOrMoreZeros = 0;

        for (int num : nums)
            if (num == 0) oneOrMoreZeros++;
            else multi *= num;
        
        if (oneOrMoreZeros > 1) return new int[nums.length];
            
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++)
            if (oneOrMoreZeros == 1) result[i] = (nums[i] == 0) ? multi : 0;
            else result[i] = multi / nums[i];
        
        return result;
    }
}  
