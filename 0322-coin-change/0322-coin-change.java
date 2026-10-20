class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int ans = helper(0, coins, amount, dp);

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public int helper(int i, int[] coins, int amount, int[][] dp) {
        if (amount == 0)
            return 0;

        if (i >= coins.length)
            return Integer.MAX_VALUE;

        if (dp[i][amount] != -1)
            return dp[i][amount];

        int skip = helper(i + 1, coins, amount, dp);

        int pick = Integer.MAX_VALUE;
        if (coins[i] <= amount) {
            int next = helper(i, coins, amount - coins[i], dp);

            if (next != Integer.MAX_VALUE) {
                pick = 1 + next;
            }
        }

        return dp[i][amount] = Math.min(skip, pick);
    }
}