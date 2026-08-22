class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k == 0) return false;

        for (int i = 0, j = 1; i < nums.length - 1; j++) {
            if (Math.abs(i - j) > k || j == nums.length) { i++; j = i; } 
            else if (nums[i] == nums[j]) return true;
        }

        return false;
    }
}