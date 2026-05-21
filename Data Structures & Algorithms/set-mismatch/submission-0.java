class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] set = new int[nums.length];
        int[] res = new int[2];

        for (int num : nums) {
            if (set[num - 1] > 0) res[0] = num;
            set[num - 1] = num;
        } 

        for (int i = 0; i < set.length; i++)
            if (set[i] == 0) {
                res[1] = i + 1;
                break;
            }

        return res;
    }
}