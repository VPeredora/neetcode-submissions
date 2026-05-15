class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int pointer1 = 0, pointer2 = 0;
        Set<Integer> result = new HashSet<>();

        while (pointer1 < nums1.length && pointer2 < nums2.length) {
            while (pointer1 < nums1.length && nums1[pointer1] < nums2[pointer2]) pointer1++;
            if (pointer1 < nums1.length) {
                if (nums1[pointer1] == nums2[pointer2]) result.add(nums1[pointer1]);
                pointer2++;
                while (pointer2 < nums2.length && nums2[pointer2] == nums2[pointer2 - 1]) pointer2++;
            }
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}