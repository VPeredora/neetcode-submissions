class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> common = new HashSet<>();
        Set<Integer> distinct = new HashSet<>();
        for (int num1 : nums1)
            distinct.add(num1);
        
        List<Integer> answer2 = new ArrayList<>();
        for (int num2 : nums2)
            if (!distinct.contains(num2) && !answer2.contains(num2)) 
                answer2.add(num2);
            else common.add(num2);
        
        List<Integer> answer1 = new ArrayList<>();
        for (int num1 : distinct)
            if (!common.contains(num1)) answer1.add(num1);

        return List.of(answer1, answer2);
    }
}