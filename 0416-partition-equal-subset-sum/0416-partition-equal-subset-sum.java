class Solution {
    static Boolean[][] dp;

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int ele : nums) {
            sum += ele;
        }
        if (sum % 2 != 0)
            return false;

        else {
            int subsetSum = sum / 2;
            dp = new Boolean[nums.length][subsetSum + 1];
            return helper(0, subsetSum, nums);
        }
    }

    public boolean helper(int i, int sum, int[] nums) {
        if (sum == 0)
            return true;
        else if (i == nums.length)
            return false;
        if (dp[i][sum] != null) {
            return dp[i][sum];
        }
        boolean skip = helper(i + 1, sum, nums);
        boolean pick = false;
        if (nums[i] <= sum) {
            pick = helper(i + 1, sum - nums[i], nums);
        }
        return dp[i][sum] = pick || skip;
    }
}