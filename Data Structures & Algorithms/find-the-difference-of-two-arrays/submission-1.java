class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        return List.of(findDistinct(nums1, nums2), findDistinct(nums2, nums1));
    }

    private List<Integer> findDistinct(int[] A, int[] B) {
        int previous = Integer.MIN_VALUE, j = 0;
        List<Integer> res = new ArrayList<>();

        for (int num : A) {
            if (num == previous) continue;
            while (j < B.length && B[j] < num) j++;
            if (j == B.length || B[j] != num) res.add(num);
            previous = num;
        }

        return res;
    }
}