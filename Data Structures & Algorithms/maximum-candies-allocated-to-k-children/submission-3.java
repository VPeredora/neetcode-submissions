class Solution {
    public int maximumCandies(int[] candies, long k) {
        Arrays.sort(candies);
        long l = 1, r = candies[candies.length - 1];
        long result = 0;

        while (l <= r) {
            long mid = l + (r - l) / 2; // number of candies
            long kids = 0;

            for (int pile : candies) {
                kids += pile / mid;
                if (kids >= k) break;
            }

            if (kids >= k) { result = mid; l = mid + 1; }
            else r = mid - 1;
        }
         
        return (int) result;
    }
}
