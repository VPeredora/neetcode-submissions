class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < tickets.length; i++)
            queue.offer(i);

        int time = 0;
        while (tickets[k] > 0) {
            int person = queue.poll();
            tickets[person]--; time++;

            if (tickets[person] > 0) queue.offer(person);;
        }

        return time;
    }
}