class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int ROWS = matrix.length, COLS = matrix[0].length;
        int l = 0, r = ROWS * COLS - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            int midRow = mid / COLS;
            int midCol = mid % COLS;

            if (matrix[midRow][midCol] < target) l = mid + 1;
            else if (matrix[midRow][midCol] > target) r = mid - 1;
            else return true;
        }

        return false;
    }
}
