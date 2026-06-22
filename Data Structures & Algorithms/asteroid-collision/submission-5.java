class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (int asteroid : asteroids) {
            while (asteroid < 0 && !stack.isEmpty() && stack.peek() > 0) {
                int collision = stack.peek() + asteroid;
                if (collision < 0) stack.pop();
                else if (collision > 0) asteroid = 0;
                else {stack.pop(); asteroid = 0;}
            }
            
            if (asteroid != 0) stack.push(asteroid);
        }

        return stack.stream().mapToInt(Integer::intValue).toArray();
    }
}
