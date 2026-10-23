class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length(), n = str2.length();
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int x = (i - 1 >= 0 && j - 1 >= 0) ? dp[i - 1][j - 1] : 0;
                int y = (i - 1 >= 0) ? dp[i - 1][j] : 0;
                int z = (j - 1 >= 0) ? dp[i][j - 1] : 0;
                if (str1.charAt(i) == str2.charAt(j))
                    dp[i][j] = 1 + x;
                else
                    dp[i][j] = Math.max(y, z);
            }
        }

        String lcs = buildLCS(str1, str2, dp);
        StringBuilder ans = new StringBuilder();
        int i = 0, j = 0;

        for (char c : lcs.toCharArray()) {
            while (i < str1.length() && str1.charAt(i) != c)
                ans.append(str1.charAt(i++));
            while (j < str2.length() && str2.charAt(j) != c)
                ans.append(str2.charAt(j++));

            ans.append(c);
            i++;
            j++;
        }

        while (i < str1.length())
            ans.append(str1.charAt(i++));
        while (j < str2.length())
            ans.append(str2.charAt(j++));

        return ans.toString();
    }

    static String buildLCS(String text1, String text2, int[][] dp) {
        StringBuilder sb = new StringBuilder();
        int i = text1.length() - 1, j = text2.length() - 1;

        while (i >= 0 && j >= 0) {
            if (text1.charAt(i) == text2.charAt(j)) {
                sb.append(text1.charAt(i));
                i--;
                j--;
            } else {
                int up = (i - 1 >= 0) ? dp[i - 1][j] : 0;
                int left = (j - 1 >= 0) ? dp[i][j - 1] : 0;
                if (up >= left)
                    i--;
                else
                    j--;
            }
        }
        return sb.reverse().toString();
    }
}