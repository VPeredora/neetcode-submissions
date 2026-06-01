class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int p1 = 0, p2 = 0, N1 = nums1.length, N2 = nums2.length;
        Set<Integer> intersection = new HashSet<>();

        while (p1 < N1 && p2 < N2) {
            while (p1 < N1 && nums1[p1] < nums2[p2]) p1++;
            if (p1 < N1) {
                if (nums1[p1] == nums2[p2]) intersection.add(nums1[p1]);
                p2++;  
                while (p2 < N2 && nums2[p2] == nums2[p2 - 1]) p2++; 
            }
        }

        return intersection.stream().mapToInt(Integer::intValue).toArray();
    }
}