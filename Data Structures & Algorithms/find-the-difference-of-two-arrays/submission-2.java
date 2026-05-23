class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> distinct1 = new HashSet<>();
        Set<Integer> distinct2 = new HashSet<>();
        for (int num : nums1) distinct1.add(num);
        for (int num : nums2) distinct2.add(num);

        List<Integer> answer1 = new ArrayList<>(distinct1);
        answer1.removeAll(distinct2);

        List<Integer> answer2 = new ArrayList<>(distinct2);
        answer2.removeAll(distinct1);

        return List.of(answer1, answer2);
    }
}