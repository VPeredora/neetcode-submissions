class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<int[]> warmerDays = new ArrayDeque<>();
        int[] result = new int[temperatures.length];

        for (int i = temperatures.length - 1; i >= 0; i--) {
            if (!warmerDays.isEmpty()) {
                while (!warmerDays.isEmpty() && warmerDays.peek()[0] <= temperatures[i]) 
                    warmerDays.pop();
                if (warmerDays.isEmpty()) warmerDays.push(new int[] {temperatures[i], i});
                else  {
                    result[i] = warmerDays.peek()[1] - i;
                    warmerDays.push(new int[] {temperatures[i], i});
                }
            } else warmerDays.push(new int[] {temperatures[i], i});
        }
            

        return result;
    }
}
