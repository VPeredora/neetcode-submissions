class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int multi = 1, oneOrMoreZeros = 0;

        for (int i = 0; i < nums.length; i++)
            if (nums[i] == 0) oneOrMoreZeros++;
            else multi *= nums[i];
        
        if (oneOrMoreZeros > 1) return result;
        if (oneOrMoreZeros == 1)
            for (int i = 0; i < nums.length; i++)
                if (nums[i] == 0) {
                    result[i] = multi;
                    return result;
                }
            
        for (int i = 0; i < nums.length; i++)
            result[i] = multi / nums[i];
        
        return result;
    }
}  
