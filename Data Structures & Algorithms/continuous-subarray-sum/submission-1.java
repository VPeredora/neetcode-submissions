class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> remainders = new HashMap<>(nums.length);
        remainders.put(0, -1);
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int r = sum % k;
            if (!remainders.containsKey(r)) remainders.put(r, i);
            else if (i - remainders.get(r) > 1) return true;
        }

        return false;
    }
}