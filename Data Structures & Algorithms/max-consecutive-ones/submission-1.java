class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int pointer = 0, number = 0;
        
        for (int i : nums) {
            if (i == 0) {
                number = Math.max(number, pointer);
                pointer = 0;
            } else { pointer++; }
        }

        return Math.max(number, pointer);
    }
}