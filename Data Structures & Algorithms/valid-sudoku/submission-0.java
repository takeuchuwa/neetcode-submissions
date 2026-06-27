class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] columns = new boolean[9][9];
        boolean[][] square = new boolean[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char symbol = board[i][j];
                if (symbol != '.') {
                    int s = symbol - '0' - 1;
                    if (!rows[i][s]) {
                        rows[i][s] = true;
                    } else {
                        return false;
                    }
                    if (!columns[j][s]) {
                        columns[j][s] = true;
                    } else  {
                        return false;
                    }
                    int sq = getSquare(i, j);
                    System.out.println(sq);
                    if (!square[sq][s]) {
                        square[sq][s] = true;
                    } else {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    private int getSquare(int i, int j) {
        int row = i / 3;
        int column = j / 3;
        return row * 3 + column;
    }
}
