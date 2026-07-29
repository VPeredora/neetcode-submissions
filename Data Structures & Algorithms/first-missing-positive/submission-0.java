class Solution {
    public int firstMissingPositive(int[] nums) {
        int missing = 1;

        while (true) {
            boolean found = false;
            for (int num : nums) {
                if (missing == num) {
                    found = true;
                    break;
                }
            }
            if (!found) return missing;
            missing++;
        }
    }
}