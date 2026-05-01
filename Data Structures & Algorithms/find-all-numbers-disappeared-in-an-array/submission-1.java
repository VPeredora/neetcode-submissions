class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> allNumbers = IntStream.range(1, nums.length + 1).boxed().collect(Collectors.toSet());
        
        for (int i : nums)
            allNumbers.remove(i);
        
        return new ArrayList<>(allNumbers);
    }
}
