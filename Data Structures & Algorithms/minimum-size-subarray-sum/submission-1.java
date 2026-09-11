class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int[] prefix = new int[nums.length + 1];
        int minimum = nums.length + 1;

        for (int i = 0; i < nums.length; i++)
            prefix[i + 1] = prefix[i] + nums[i];

        for (int i = 0; i < nums.length; i++) {
            int l = i, r = nums.length;

            while (l < r) {
                int mid = l + ((r - l) / 2);
                int sum = prefix[mid + 1] - prefix[i];
                
                if (sum >= target) r = mid;
                else l = mid + 1;
            }

            if (l != nums.length)
                minimum = Math.min(minimum, l - i + 1);
        }

        
        return minimum % (nums.length + 1);
    }
}