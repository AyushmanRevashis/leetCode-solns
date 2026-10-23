class Solution {
    static int[][] dp;

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        dp = new int[n][n + 1];
        for (int[] rows : dp) {
            Arrays.fill(rows, -1);
        }
        return helper(0, -1, nums);
    }

    public int helper(int idx, int prev, int[] nums) {
        if (idx == nums.length)
            return 0;
        if (dp[idx][prev + 1] != -1)
            return dp[idx][prev + 1];
        int skip = helper(idx + 1, prev, nums);
        if (prev != -1 && nums[prev] >= nums[idx])
            return dp[idx][prev + 1] = skip;
        int pick = 1 + helper(idx + 1, idx, nums);
        return dp[idx][prev + 1] = Math.max(skip, pick);
    }
}
