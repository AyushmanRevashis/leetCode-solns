class Solution {
    static int[][] dp;
    static int sum;

    public int findTargetSumWays(int[] nums, int target) {
        sum = 0;
        for (int ele : nums) {
            sum += ele;
        }
        dp = new int[nums.length][2 * sum + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return helper(0, target, nums);
    }

    public int helper(int i, int target, int[] nums) {
        if (i == nums.length) {
            if (target == 0)
                return 1;
            else
                return 0;
        }
        int shifted = target + sum;
        if (shifted < 0 || shifted >= dp[0].length) {
            return 0;
        }
        if (dp[i][shifted] != -1)
            return dp[i][shifted];
        int subtract = helper(i + 1, target - nums[i], nums);
        int add = helper(i + 1, target + nums[i], nums);
        return dp[i][shifted] = add + subtract;
    }
}