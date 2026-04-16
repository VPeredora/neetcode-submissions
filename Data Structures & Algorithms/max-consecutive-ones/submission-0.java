class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int pointer = 0, number = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) pointer++;
            if (nums[i] == 0 || i == nums.length - 1) {
                number = number < pointer ? pointer : number;
                pointer = 0;
            }
        }
        return number;
    }
}
