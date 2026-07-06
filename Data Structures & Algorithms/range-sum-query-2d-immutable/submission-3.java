class NumMatrix {
    private int[][] matrix;

    public NumMatrix(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        this.matrix = new int[rows + 1][cols + 1];

        for (int i = 0; i < rows; i++) {
            int prefix = 0;
            for (int j = 0; j < cols; j++) {
                prefix += matrix[i][j];
                int above = this.matrix[i][j + 1];
                this.matrix[i + 1][j + 1] += prefix + above;
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        row1++; col1++; row2++; col2++;
        int bottomRight = matrix[row2][col2];
        int above = matrix[row1 - 1][col2];
        int left = matrix[row2][col1 - 1];
        int topLeft = matrix[row1 - 1][col1 - 1];

        return bottomRight - above - left + topLeft;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */