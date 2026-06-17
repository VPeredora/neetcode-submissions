class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] cars = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars, (x, y) -> Integer.compare(y[0], x[0]));

        Deque<Double> highway = new ArrayDeque<>();

        for (int[] car : cars) {
            double time = (double) (target - car[0]) / car[1];
            if (!highway.isEmpty() && time <= highway.peek()) continue;
            highway.push(time);
        }

        return highway.size();
    }
}
