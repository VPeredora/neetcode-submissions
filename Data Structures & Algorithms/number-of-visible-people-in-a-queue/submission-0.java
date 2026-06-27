class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int[] answer = new int[heights.length];

        for (int i = 0; i < answer.length - 1; i++) {
            int amount = 0, highest = heights[i + 1] - 1;

            for (int j = i + 1; j < heights.length; j++) {
                if (heights[j] >= heights[i]) {amount++; break;}
                if (heights[j] > highest)  {
                    amount++;
                    highest = heights[j];
                }
            }

            answer[i] = amount;
        }

        return answer;
    }
}