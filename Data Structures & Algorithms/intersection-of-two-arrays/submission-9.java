class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> distinct1 = new HashSet<>();
        for (int num : nums1)
            distinct1.add(num);

        Set<Integer> distinct2 = new HashSet<>();
        for (int num : nums2)
            distinct2.add(num);
        
        distinct1.retainAll(distinct2);

        int[] intersection = new int[distinct1.size()];
        int index = 0;
        for (int num : distinct1)
            intersection[index++] = num;
        
        return intersection;
    }
}