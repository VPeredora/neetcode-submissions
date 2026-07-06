class NumMatrix {
    private int[][] matrix;

    public NumMatrix(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length; 
        this.matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            this.matrix[i][0] = matrix[i][0];
            for (int j = 1; j < cols; j++)
                this.matrix[i][j] += this.matrix[i][j - 1] + matrix[i][j];
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;

        for (int i = row1; i <= row2; i++)
            sum += matrix[i][col2] - (col1 == 0 ? 0 : matrix[i][col1 - 1]);

        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */