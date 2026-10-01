class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> inc = new ArrayDeque<>();
        Deque<Integer> dec = new ArrayDeque<>();
        int l = 0;

        for (int r = 0; r < nums.length; r++) {
            while (!inc.isEmpty() && nums[r] > inc.peekLast()) inc.removeLast();
            while (!dec.isEmpty() && nums[r] < dec.peekLast()) dec.removeLast();

            inc.add(nums[r]);
            dec.add(nums[r]);

            if (inc.peekFirst() - dec.peekFirst() > limit) {
                if (nums[l] == inc.peekFirst()) inc.removeFirst();
                if (nums[l] == dec.peekFirst()) dec.removeFirst();
                l++;
            }
        }

        return nums.length - l;
    }
}