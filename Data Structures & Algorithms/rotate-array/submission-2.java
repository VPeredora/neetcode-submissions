class Solution {
    public void rotate(int[] nums, int k) {
        int N = nums.length;
        k %= N;
        int count = 0;

        for (int start = 0; count < N; start++) {
            int current = start;
            int prev = nums[start];

            do {
                int nextIdx = (current + k) % N;
                int temp = nums[nextIdx];
                nums[nextIdx] = prev;
                prev = temp;
                current = nextIdx;
                count++;
            } while (start != current);
        }
    }
}