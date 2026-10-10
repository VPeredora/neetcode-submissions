class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int ROWS = matrix.length, COLS = matrix[0].length;
        int top = 0, bot = ROWS - 1;

        while (top < bot) {
            int row = top + (bot - top) / 2;

            if (matrix[row][COLS - 1] < target) top = row + 1;
            else bot = row;
        }

        int l = 0, r = COLS - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (matrix[top][mid] > target) r = mid - 1;
            else if (matrix[top][mid] < target) l = mid + 1;
            else return true;
        }

        return false;
    }
}
