class NumMatrix {
    private int[][] matrix;

    public NumMatrix(int[][] matrix) {
        int rows = matrix.length, columns = matrix[0].length; 
        this.matrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            int pref = 0;
            for (int j = 0; j < columns; j++) {
                pref += matrix[i][j];
                this.matrix[i][j] = pref;
            }
        }

        for (int i = 0; i < matrix.length; i++)
            System.out.println(Arrays.toString(this.matrix[i]));
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;

        for (int i = row1; i <= row2; i++) {
            int[] row = matrix[i];
            sum += row[col2] - (col1 == 0 ? 0 : row[col1 - 1]);
        }

        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */