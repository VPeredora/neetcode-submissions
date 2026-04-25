class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int pointer1 = 0, pointer2 = nums2.length - 1, temp = 0;

        while (pointer1 < nums1.length) {
            while (pointer2 >= 0 && nums1[pointer1] != nums2[pointer2]) {
                if (nums2[pointer2] > nums1[pointer1]) temp = nums2[pointer2];
                pointer2--;
            }
            nums1[pointer1] = temp == 0 ? -1 : temp;

            pointer1++;
            pointer2 = nums2.length - 1;
            temp = 0;
        }

        return nums1;
    }
}