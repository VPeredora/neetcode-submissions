class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int length = 1, tempI = 1, tempD = 1;

        for (int i = 0; i < nums.length - 1; i++) {
            while (i < nums.length - 1 && nums[i] < nums[i + 1]) {
                tempI++;
                i++;
            }
            while (i < nums.length - 1 && nums[i] > nums[i + 1]) {
                tempD++;
                i++;
            }
            if (tempI > 1 || tempD > 1) {
                length = Math.max(tempI, length);
                length = Math.max(tempD, length);
                tempI = 1;
                tempD = 1;
                i--;
            }
        }

        return length;
    }
}
