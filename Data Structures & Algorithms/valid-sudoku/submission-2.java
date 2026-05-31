class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] rows = new int[board.length];
        int[] columns = new int[board.length];
        int[] squares = new int[board.length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == '.') continue;
                int value = board[i][j] - 1;

                if ((rows[i] & (1 << value)) > 0 || (columns[j] & (1 << value)) > 0
                   || (squares[(i / 3) * 3 + (j / 3)] & (1 << value)) > 0)
                    return false;
                
                rows[i] |= (1 << value);
                columns[j] |= (1 << value);
                squares[(i / 3) * 3 + (j / 3)] |= (1 << value);
            }
        }

        return true;
    }
}
