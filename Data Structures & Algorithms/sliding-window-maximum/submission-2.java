class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Queue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        int[] result = new int[nums.length - k + 1];
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            maxHeap.offer(new int[]{nums[i], i});
            if (i + 1 >= k) {
                while (maxHeap.peek()[1] <= i - k) maxHeap.poll();
                result[index++] = maxHeap.peek()[0];
            }
        }
          
        return result;
    }
}
