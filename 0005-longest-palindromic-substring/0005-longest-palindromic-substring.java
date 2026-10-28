class Solution {

      public String longestPalindrome(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        int maxLen = 1;
        for (int i = 0; i < n; i++) {
            int row = 0;
            for (int col = i; col < n; col++) {
                if (row == col)
                    dp[row][col] = 1;
                else if (s.charAt(row) == s.charAt(col) && (col - row == 1 || dp[row + 1][col - 1] != 0))
                    dp[row][col] = dp[row + 1][col - 1] + 2;
                maxLen = Math.max(maxLen, dp[row][col]);
                row++;
            }
        }
        String ans = "";
        for (int i = 0; i < n; i++) {
            int row = 0;
            for (int col = i; col < n; col++) {
                if (dp[row][col] == maxLen) {
                    ans = s.substring(row, col + 1);
                    return ans;
                }
                 row++;
            }
        }
        return ans;
    }
}