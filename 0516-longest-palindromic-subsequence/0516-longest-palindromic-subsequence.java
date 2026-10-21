class Solution {
    static int[][] dp;

    public int longestPalindromeSubseq(String s) {
        StringBuilder a = new StringBuilder(s);
        StringBuilder b = new StringBuilder(s);
        b.reverse();
        return longestCommonSubsequence(a, b);
    }

    public int longestCommonSubsequence(StringBuilder text1, StringBuilder text2) {
        int n1 = text1.length();
        int n2 = text2.length();
        dp = new int[n1][n2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return LCS(n1 - 1, n2 - 1, new StringBuilder(text1), new StringBuilder(text2));
    }

    public int LCS(int i, int j, StringBuilder text1, StringBuilder text2) {
        if (i < 0 || j < 0)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        if (text1.charAt(i) == text2.charAt(j)) {
            return dp[i][j] = 1 + LCS(i - 1, j - 1, text1, text2);
        } else {
            return dp[i][j] = Math.max(LCS(i - 1, j, text1, text2), LCS(i, j - 1, text1, text2));
        }
    }
}