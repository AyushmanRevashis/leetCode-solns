class Solution {
    public int matrixScore(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 0) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] ^= 1;
                }
            }
        }
        for (int j = 0; j < n; j++) {
            int zeroes = 0, ones = 0;
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == 1)
                    ones++;
                else
                    zeroes++;
            }
            if (zeroes > ones) {
                for (int k = 0; k < m; k++) {
                    grid[k][j] ^= 1;
                }
            }

        }
        int sum = 0;
        int pow = 1;
        for (int j = n - 1; j >= 0; j--) {
            int ones = 0;
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == 1)
                    ones++;
            }
            sum += pow * ones;
            pow *= 2;
        }
        return sum;
    }
}