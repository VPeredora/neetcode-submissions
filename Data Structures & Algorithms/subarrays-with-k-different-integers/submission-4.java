class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        int l_far = 0, l_near = 0, result = 0;

        for (int r = 0; r < nums.length; r++) {
            count.merge(nums[r], 1, Integer::sum);

            while (count.size() > k) {
                int nearNum = nums[l_near++];
                count.merge(nearNum, -1, Integer::sum);
                if (count.get(nearNum) == 0) count.remove(nearNum);
                l_far = l_near;
            }

            while (count.get(nums[l_near]) > 1)
                count.merge(nums[l_near++], -1, Integer::sum);

            if (count.size() == k) result += l_near - l_far + 1;
        }

        return result;
    }
}