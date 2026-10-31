class Solution {
    public boolean checkValidGrid(int[][] grid) {
        return validPath(0, 0, grid, 0);
    }

    private boolean validPath(int row, int col, int[][] grid, int exptVal) {
        int n = grid.length;
        if (row < 0 || col < 0 || row >= n || col >= n ||
                grid[row][col] != exptVal) {
            return false;
        }

        if (exptVal == n * n - 1) {
            return true;
        }
        // up right
        boolean ans1 = validPath(row - 2, col + 1, grid, exptVal + 1);
        // up left
        boolean ans2 = validPath(row - 2, col - 1, grid, exptVal + 1);
        // down right
        boolean ans3 = validPath(row + 2, col + 1, grid, exptVal + 1);
        // down left
        boolean ans4 = validPath(row + 2, col - 1, grid, exptVal + 1);
        // up front
        boolean ans5 = validPath(row - 1, col + 2, grid, exptVal + 1);
        // up down
        boolean ans6 = validPath(row + 1, col + 2, grid, exptVal + 1);
        // up back
        boolean ans7 = validPath(row - 1, col - 2, grid, exptVal + 1);
        // down back
        boolean ans8 = validPath(row + 1, col - 2, grid, exptVal + 1);
        return ans1 || ans2 || ans3 || ans4 || ans5 || ans6 || ans7 || ans8;
    }
}