class Solution {
    public void wiggleSort(int[] nums) {
        boolean wiggle = true;

        for (int i = 0; i < nums.length - 1; i++) {
            if ((wiggle && nums[i] > nums[i + 1]) || 
               (!wiggle && nums[i] < nums[i + 1])) { 
                swap(nums, i, i + 1); 
            }
            wiggle = !wiggle;
        }
    }

    private void swap(int[] nums, int a, int b) {
        int swapTemp = nums[a];
        nums[a] = nums[b];
        nums[b] = swapTemp;
    }
}
