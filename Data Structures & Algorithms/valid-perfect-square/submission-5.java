class Solution {
    public boolean isPerfectSquare(int num) {
        int r = 0, mask = 1 << 15;
        
        while (mask > 0) {
            r |= mask;

            if (r > num / r) r ^= mask;
            
            mask >>= 1;
        }

        return r * r == num;
    }
}