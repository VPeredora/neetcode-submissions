class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] result = new int[heights.length];

        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[i] > heights[stack.peek()])
                result[stack.pop()]++;

            if (!stack.isEmpty()) result[stack.peek()]++;
            stack.push(i);
        }

        return result;
    }
}