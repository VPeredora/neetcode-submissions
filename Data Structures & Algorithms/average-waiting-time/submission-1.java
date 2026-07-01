class Solution {
    public double averageWaitingTime(int[][] customers) {
        long time = customers[0][0], average = 0;

        for (int[] customer : customers) {
            time = Math.max(time, customer[0]) + customer[1];
            average += time - customer[0];
        }

        return (double) average / customers.length;
    }
}