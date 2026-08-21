class Solution {
    public int trap(int[] height) {
        if (height.length == 0) return 0;

        Deque<Integer> bars = new ArrayDeque<>();
        int amount = 0;

        for (int i = 0; i < height.length; i++) {
            while (!bars.isEmpty() && height[i] >= height[bars.peek()]) {
                int mid = height[bars.pop()];

                if (!bars.isEmpty()) {
                    int right = height[i];
                    int left = height[bars.peek()];
                    int h = Math.min(right, left) - mid;
                    int w = i - bars.peek() - 1;
                    amount += h * w;
                }
            }
            bars.push(i);
        }
        
        return amount;
    }
}
