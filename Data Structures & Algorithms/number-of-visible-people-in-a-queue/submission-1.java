class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] result = new int[heights.length];

        for (int i = heights.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[i] > stack.peek()) {
                stack.pop();
                result[i]++;
            }

            if (!stack.isEmpty()) result[i]++;
            stack.push(heights[i]);
        }

        return result;
    }
}
