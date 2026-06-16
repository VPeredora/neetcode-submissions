class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<int[]> frozyDays = new ArrayDeque<>();
        int[] result = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            while (!frozyDays.isEmpty() && frozyDays.peek()[0] < temperatures[i]) {
                int[] frozyDay = frozyDays.pop();
                result[frozyDay[1]] = i - frozyDay[1];
            }
            frozyDays.push(new int[] {temperatures[i], i});
        }

        return result;
    }
}
