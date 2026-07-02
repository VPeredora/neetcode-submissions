class Solution {
    public void sortColors(int[] nums) {
        int zero = 0, one = 0;

        for (int two = 0; two < nums.length; two++) {
            int current = nums[two];
            nums[two] = 2;
            if (current < 2) nums[one++] = 1;
            if (current < 1) nums[zero++] = 0;
        }
    }
}