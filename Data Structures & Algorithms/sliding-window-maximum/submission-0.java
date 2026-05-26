class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> result = new ArrayList<>(nums.length - k + 1);

        for (int i = 0; i < nums.length - k + 1; i++) {
            int max = nums[i];
            for (int j = i + 1; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }
            result.add(max);
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
