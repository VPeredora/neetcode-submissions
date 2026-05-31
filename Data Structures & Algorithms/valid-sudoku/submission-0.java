class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> unique = new HashSet<>();

        for (char[] array : board) {
            for (char c : array)
                if (Character.isDigit(c) && !unique.add(c)) return false;
            unique.clear();
        }
            
        for (int i = 0; i < board[0].length; i++) {
            for (char[] array : board)
                if (Character.isDigit(array[i]) && !unique.add(array[i])) return false;
            unique.clear();
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 3 * (i / 3); j < (3 * (i / 3) + 3); j++)
                for (int k = 3 * (i % 3); k < (3 * (i % 3) + 3); k++)
                    if (Character.isDigit(board[j][k]) && !unique.add(board[j][k])) return false;
            unique.clear();
        }

        return true;
    }
}
