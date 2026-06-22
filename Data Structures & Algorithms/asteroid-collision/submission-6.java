class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int top = -1;

        for (int asteroid : asteroids) {
            while (asteroid < 0 && top >= 0 && asteroids[top] > 0) {
                if (asteroids[top] > Math.abs(asteroid)) asteroid = 0;
                else if (asteroids[top] < Math.abs(asteroid)) top--;
                else {asteroid = 0; top--;}
            } 
            if (asteroid != 0) asteroids[++top] = asteroid;
        }

        return Arrays.copyOfRange(asteroids, 0, top + 1);
    }
}