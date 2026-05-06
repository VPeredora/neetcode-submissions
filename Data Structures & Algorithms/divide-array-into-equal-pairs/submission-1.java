class Solution {
    public boolean divideArray(int[] nums) {
        Set<Integer> pair = new HashSet<>();
        
        for (int num : nums)
            if (!pair.add(num)) pair.remove(num);

        return pair.isEmpty();
    }
}