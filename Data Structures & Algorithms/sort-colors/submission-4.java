class Solution {
    public void sortColors(int[] nums) {
        int l = 0, i = 0, r = nums.length - 1;

        while (i <= r) {
            if (nums[i] == 0) swap(nums, i, l++);
            else if (nums[i] == 2) swap(nums, i--, r--);
            i++;
        }
    }

    private static void swap(int[] arr, int a, int b) {
        int swapTemp = arr[a];
        arr[a] = arr[b];
        arr[b] = swapTemp;
    }
}