class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Queue<int[]> maxHeap = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        Queue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        int result = 1;

        for (int l = 0, r = 0; r < nums.length; r++) {
            maxHeap.offer(new int[]{nums[r], r});
            minHeap.offer(new int[]{nums[r], r});

            if (maxHeap.peek()[0] - minHeap.peek()[0] > limit) {
                l++;
                while (!maxHeap.isEmpty() && maxHeap.peek()[1] < l) maxHeap.poll();
                while (!minHeap.isEmpty() && minHeap.peek()[1] < l) minHeap.poll();
            }

            result = Math.max(result, r - l + 1);
        }

        return result;
    }
}