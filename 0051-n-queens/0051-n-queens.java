class Solution {
       public List<List<String>> solveNQueens(int n) {
        char[][] chessBoard = new char[n][n];
        for (char[] rows : chessBoard) {
            Arrays.fill(rows, '.');
        }
        List<List<String>> ans = new ArrayList<>();
        nQueens(0, chessBoard, ans);
        return ans;
    }

    private void nQueens(int row, char[][] chessBoard, List<List<String>> ans) {
        int n = chessBoard.length;
        if (row == n) {
            List<String> validAns = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                validAns.add(new String(chessBoard[i]));
            }

            ans.add(validAns);
            return;
        }
        for (int col = 0; col < n; col++) {
            if (canQueenBePlaced(row, col, chessBoard)) {
                chessBoard[row][col] = 'Q';
                nQueens(row + 1, chessBoard, ans);
                chessBoard[row][col] = '.';
            }
        }
    }

    private boolean canQueenBePlaced(int row, int col, char[][] chessBoard) {
        int n = chessBoard.length;
        int i = row - 1;
        // col check
        while (i >= 0) {
            if (chessBoard[i][col] == 'Q') {
                return false;
            }
            i--;
        }
        // left digonal check
        i = row - 1;
        int j = col - 1;
        while (i >= 0 && j >= 0) {
            if (chessBoard[i][j] == 'Q') {
                return false;
            }
            i--;
            j--;
        }
        // right digonal check
        i = row - 1;
        j = col + 1;
        while (i >= 0 && j < n) {
            if (chessBoard[i][j] == 'Q') {
                return false;
            }
            i--;
            j++;
        }
        // kuch nhi hua to
        return true;
    }
}