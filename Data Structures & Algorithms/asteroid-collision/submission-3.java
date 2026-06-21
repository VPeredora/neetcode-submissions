class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (int asteroid : asteroids) {
            if (asteroid > 0) stack.push(asteroid);
            else {
                boolean isDestroyed = false;
                while (!stack.isEmpty() && stack.peek() > 0) {
                    int collision = stack.peek() + asteroid;
                    if (collision > 0) {isDestroyed = true; break;}
                    else if (collision == 0) {isDestroyed = true; stack.pop(); break;}
                    else stack.pop();
                }
                if (!isDestroyed && (stack.isEmpty() || stack.peek() < 0)) stack.push(asteroid);
            }
        }

        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--)
            result[i] = stack.pop();

        return result;
    }
}