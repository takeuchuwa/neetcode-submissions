class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (dfs(board, word, row, col, 0, visited, rows, cols)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int row, int col, int i, boolean[][] visited,
        int rows, int cols) {
        if (i == word.length()) {
            return true;
        }

        if (row < 0 || col < 0 || row == rows || col == cols || visited[row][col]) {
            return false;
        }

        visited[row][col] = true;
        boolean match = false;
        if (word.charAt(i) == board[row][col]) {
            i++;
            match = dfs(board, word, row + 1, col, i, visited, rows, cols)
                || dfs(board, word, row - 1, col, i, visited, rows, cols)
                || dfs(board, word, row, col + 1, i, visited, rows, cols)
                || dfs(board, word, row, col - 1, i, visited, rows, cols);
        }
        visited[row][col] = false;

        return match;
    }
}
