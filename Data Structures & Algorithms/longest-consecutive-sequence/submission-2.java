class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);

        int result = 0;
        for (int i = 0; i < nums.length;) {
            int number = nums[i], sequence = 1;

            while (i < nums.length) {
                if (number == nums[i]) {i++; continue;}
                if (++number != nums[i]) break;
                sequence++; i++;
            }

            result = Math.max(result, sequence);
        }
        

        return result;
    }
}
