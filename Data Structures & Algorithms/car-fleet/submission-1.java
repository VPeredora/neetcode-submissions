class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] cars = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars, (x, y) -> Integer.compare(y[0], x[0]));

        Deque<Double> highway = new ArrayDeque<>();
        int fleets = 0;

        for (int i = 0; i < position.length; i++) {
            double time = (double) (target - cars[i][0]) / cars[i][1];

            if (!highway.isEmpty()) {
                double frontCarTime = highway.peek();
                if (time > frontCarTime) fleets++;
                else time = frontCarTime;
            } else fleets++;

            highway.push(time);
        }

        return fleets;
    }
}
