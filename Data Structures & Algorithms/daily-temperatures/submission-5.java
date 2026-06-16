class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        int N = temperatures.length;

        for (int i = N - 2; i >= 0; i--) {
            int j = i + 1;
            while (j < N && temperatures[j] <= temperatures[i]) {
                if (result[j] == 0) {j = N; break;}
                j += result[j];
            }
            if (j < N) result[i] = j - i;
        }

        return result;
    }
}
