class Solution {
    public boolean isPerfectSquare(int num) {
        long root = num;
        while (root * root > num)
            root = (root + num / root) / 2;
        return root * root == num;
    }
}