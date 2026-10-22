class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int x = (i - 1 >= 0 && j - 1 >= 0) ? dp[i - 1][j - 1] : 0;
                int y = (i - 1 >= 0) ? dp[i - 1][j] : 0;
                int z = (j - 1 >= 0) ? dp[i][j - 1] : 0;
                if (text1.charAt(i) == text2.charAt(j))
                    dp[i][j] = 1 + x;
                else
                    dp[i][j] = Math.max(y, z);
            }
        }
        return dp[m - 1][n - 1];
    }
}