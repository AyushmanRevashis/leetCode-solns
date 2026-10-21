class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return helper(0, target, nums);
    }

    public int helper(int i, int target, int[] nums) {
        if (i == nums.length) {
            if (target == 0)
                return 1;
            else
                return 0;
        }
        int subtract = helper(i + 1, target - nums[i], nums);
        int add = helper(i + 1, target + nums[i], nums);
        return add + subtract;
    }
}