class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> uniqueRow = new HashMap<>();
        Map<Integer, Set<Character>> uniqueColumn = new HashMap<>();
        Map<String, Set<Character>> uniqueSquare = new HashMap<>();

        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == '.') continue;
                String square = (i / 3) + "," + (j / 3);

                if (uniqueRow.computeIfAbsent(i, v -> new HashSet<>()).contains(board[i][j]) ||
                    uniqueColumn.computeIfAbsent(j, v -> new HashSet<>()).contains(board[i][j]) ||
                    uniqueSquare.computeIfAbsent(square, v -> new HashSet<>()).contains(board[i][j]))
                    return false;
                
                uniqueRow.get(i).add(board[i][j]);
                uniqueColumn.get(j).add(board[i][j]);
                uniqueSquare.get(square).add(board[i][j]);
            }

        return true;
    }
}
