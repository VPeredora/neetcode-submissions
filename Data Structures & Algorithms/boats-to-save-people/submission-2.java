class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int MAX = Arrays.stream(people).max().getAsInt();
        int[] count = new int[MAX + 1];
        for (int p : people)
            count[p]++;
        
        int idx = 0, i = 1;
        while (idx < people.length) {
            while (count[i] == 0) i++;
            people[idx++] = i;
            count[i]--;
        }

        int result = 0, l = 0, r = people.length - 1;
        while (l <= r) {
            int remain = limit - people[r--];
            result++;

            if (l <= r && remain >= people[l]) l++;
        }

        return result;
    }
}