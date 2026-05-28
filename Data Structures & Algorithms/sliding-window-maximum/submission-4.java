class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int n = nums.length, left = 0, right = 0;
        int[] result = new int[n - k + 1];

        while (right < n) {
            while (!deque.isEmpty() && nums[deque.getLast()] < nums[right]) deque.removeLast();
            deque.addLast(right);

            if (left > deque.getFirst()) deque.removeFirst();
            if ((right + 1) >= k) {
                result[left] = nums[deque.getFirst()];
                left++;
            }
            right++;
        }
        
        return result;
    }
}
