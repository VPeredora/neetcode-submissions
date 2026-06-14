class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            int today = temperatures[i];
            int nextDay = 0;

            for (int j = i + 1; j < temperatures.length; j++)
                if (today < temperatures[j]) {nextDay = j; break;}

            result[i] = nextDay == 0 ? 0 : nextDay - i;
        }

        return result;
    }
}
