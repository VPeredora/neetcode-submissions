class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int[] frequency = new int[2];

        for (int student : students)
            frequency[student]++;

        for (int sandwich : sandwiches) {
            if (frequency[sandwich] == 0) break;
            frequency[sandwich]--;
        }

        return frequency[0] + frequency[1];
    }
}