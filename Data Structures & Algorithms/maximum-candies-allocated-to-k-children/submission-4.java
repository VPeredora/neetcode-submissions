class Solution {
    public int maximumCandies(int[] candies, long k) {
        long l = 0, r = 0;

        for (int pile : candies)
            r = Math.max(r, pile);
        
        while (l < r) {
            long mid = l + 1 + (r - l) / 2;
            long kids = 0;

            for (int pile : candies) {
                kids += pile / mid;
                if (kids >= k) break;
            }

            if (kids >= k) l = mid;
            else r = mid - 1;
        }

        return (int) l;
    }
}
