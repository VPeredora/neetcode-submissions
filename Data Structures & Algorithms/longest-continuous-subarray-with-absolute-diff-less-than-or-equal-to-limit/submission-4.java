class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> minDeque = new ArrayDeque<>();
        Deque<Integer> maxDeque = new ArrayDeque<>();
        int result = 1;

        for (int l = 0, r = 0; r < nums.length; r++) {
            while (!minDeque.isEmpty() && nums[r] < minDeque.peekLast()) 
                minDeque.removeLast();

            while (!maxDeque.isEmpty() && nums[r] > maxDeque.peekLast())
                maxDeque.removeLast();
            
            minDeque.addLast(nums[r]);
            maxDeque.addLast(nums[r]);

            while (maxDeque.peekFirst() - minDeque.peekFirst() > limit) {
                if (nums[l] == minDeque.peekFirst()) minDeque.removeFirst();
                if (nums[l] == maxDeque.peekFirst()) maxDeque.removeFirst();
                l++;
            }

            result = Math.max(result, r - l + 1);
        }

        return result;
    }
}