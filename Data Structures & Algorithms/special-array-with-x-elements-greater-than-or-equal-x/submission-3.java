class Solution {
    public int specialArray(int[] nums) {
        int left = 1, right = nums.length;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            int amount = 0;

            for (int num : nums)
                if (num >= middle) amount++;

            if (amount == middle) return middle;
            if (amount > middle) left = middle + 1;
            else right = middle - 1;
        }

        return -1;
    }
}