class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int lRow = 0, rRow = matrix.length - 1;
        int row = 0;

        while (lRow <= rRow) {
            int mid = lRow + (rRow - lRow) / 2;
            int midLast = matrix[mid].length - 1;

            if (matrix[mid][0] > target) rRow = mid - 1;
            else if (matrix[mid][midLast] < target) lRow = mid + 1;
            else {row = mid; break;}
        }

        int l = 0, r = matrix[row].length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (matrix[row][mid] == target) return true;
            else if (matrix[row][mid] > target) r = mid - 1;
            else if (matrix[row][mid] < target) l = mid + 1;
        }

        return false;
    }
}
