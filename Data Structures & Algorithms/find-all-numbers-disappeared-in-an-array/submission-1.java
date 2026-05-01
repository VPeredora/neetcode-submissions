class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> allNumbers = IntStream.range(1, nums.length + 1).boxed().collect(Collectors.toSet());
        
        for (int i : nums)
            if (allNumbers.contains(i)) allNumbers.remove(Integer.valueOf(i));
        
        return new ArrayList<>(allNumbers);
    }
}