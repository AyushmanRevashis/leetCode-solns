class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int l = 0;
        int p = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    l = i;
                    p = j;
                }
            }
        }
        return new int[] { l, p };
    }
}