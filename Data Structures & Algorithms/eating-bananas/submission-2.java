class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = Arrays.stream(piles).max().getAsInt();

        while (l <= r) {
            int k = l + (r - l) / 2;
            int time = 0;

            for (int pile : piles)
                time += Math.ceil((double) pile / k);
            
            if (time > h) l = k + 1;
            else if (time <= h) r = k - 1;
        }

        return l;
    }
}
