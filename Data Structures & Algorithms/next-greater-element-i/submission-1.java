class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) 
            map.put(nums1[i], i);

        int[] res = new int[nums1.length];
        Arrays.fill(res, -1);

        Stack<Integer> stack = new Stack<>();
        for (int num : nums2) {
            while (!stack.isEmpty() && num > stack.peek())
                res[map.get(stack.pop())] = num;
            if (map.containsKey(num)) stack.push(num);
        }
        
        return res;
    }
}