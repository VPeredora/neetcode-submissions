class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int N = nums.length;
        int[] prefix = new int[N + 1];

        for (int i = 0; i < N; i++)
            prefix[i + 1] = nums[i] + prefix[i];

        int longest = 1;
        for (int i = 0; i < N; i++) {
            int l = 0, r = i;

            while (l <= r) {
                int mid = l + ((r - l) / 2);
                long curSum = prefix[i + 1] - prefix[mid];
                long need = (i - mid + 1) * 1L * nums[i] - curSum;

                if (need <= k) {
                    r = mid - 1;
                    longest = Math.max(longest, i - mid + 1);
                } else l = mid + 1;
            }
        } 
        

        return longest;
    }
}