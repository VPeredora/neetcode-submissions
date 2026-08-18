class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int result = 0, l = 0, r = people.length - 1;

        while (l <= r) {
            if (l == r) {result++; break;}

            if (people[l] + people[r] <= limit) { l++; r--; } 
            else r--;
            result++;
        }

        return result;
    }
}