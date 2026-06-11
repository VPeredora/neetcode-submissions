class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int index = 0, current = 1, N = nums.length;

        for (; current <= N; current++) {
            while (index < N && current > nums[index]) index++;
            
            if (current == N - index) return current;
        }

        return -1;
    }
}