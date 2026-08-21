class Solution {
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        for (int row = 0; row < rows; row++) {
            if (board[row][0] == 'O') {
                dfs(board, row, 0, rows, cols);
            }
            if (board[row][cols - 1] == 'O') {
                dfs(board, row, cols - 1, rows, cols);
            }
        }

        for (int col = 0; col < cols; col++) {
            if (board[0][col] == 'O') {
                dfs(board, 0, col, rows, cols);
            }
            if (board[rows - 1][col] == 'O') {
                dfs(board, rows - 1, col, rows, cols);
            }
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col] == 'F') {
                    board[row][col] = 'O';
                } else {
                    board[row][col] = 'X'; 
                }
            }
        }
    }

    private void dfs(char[][] board, int row, int col, int rows, int cols) {
        if (row == rows || row < 0 || col < 0 || col == cols || board[row][col] != 'O') {
            return;
        }
        board[row][col] = 'F';
        dfs(board, row + 1, col, rows, cols);
        dfs(board, row - 1, col, rows, cols);
        dfs(board, row, col + 1, rows, cols);
        dfs(board, row, col - 1, rows, cols);
    }
}
