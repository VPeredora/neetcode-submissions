class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        Deque<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < tickets.length; i++)
            queue.offer(new int[] {i, tickets[i]});

        int time = 0;
        while (!queue.isEmpty()) {
            int[] person = queue.poll();
            person[1]--; time++;

            if (person[1] == 0 && person[0] == k) break;
            else if (person[1] != 0) queue.offer(person);
        }

        return time;
    }
}