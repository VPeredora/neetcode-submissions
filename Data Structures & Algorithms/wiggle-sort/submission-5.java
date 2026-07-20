class Solution {
    public void wiggleSort(int[] nums) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : nums)
            maxHeap.add(num);

        for (int i = 1; i < nums.length; i += 2)
            nums[i] = maxHeap.poll();
        
        for (int i = 0; i < nums.length; i += 2)
            nums[i] = maxHeap.poll();
    }
}
