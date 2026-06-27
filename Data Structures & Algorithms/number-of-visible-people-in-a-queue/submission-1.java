class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] result = new int[heights.length];

        for (int i = heights.length - 1; i >= 0; i--) {
            int amount = 0;

            while (!stack.isEmpty() && heights[i] > stack.peek()) {
                stack.pop();
                amount++;
            }

            if (!stack.isEmpty()) amount++;
            stack.push(heights[i]);
            result[i] = amount;
        }

        return result;
    }
}