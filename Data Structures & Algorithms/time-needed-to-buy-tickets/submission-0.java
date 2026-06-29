class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int time = 0, person = 0;

        while (tickets[k] > 0) {
            while (tickets[person % tickets.length] == 0) 
                person++;
            
            tickets[person % tickets.length]--;
            person++; time++;
        }

        return time;
    }
}
