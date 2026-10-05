class Solution {
    public int mySqrt(int x) {
        long root = x;

        while (root * root > x)
            root = (root + x / root) >> 1;

        return (int) root;
    }
}