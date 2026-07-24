class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> remainders = new HashMap<>(Map.of(0, -1));
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            Integer index = remainders.putIfAbsent(sum % k, i);
            if (index != null && i - index > 1) return true;
        }

        return false;
    }
}