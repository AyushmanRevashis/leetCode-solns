
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        return convert(0, n - 1, nums);
    }

    public TreeNode convert(int lo, int hi, int[] nums) {
        if (lo > hi)
            return null;
        int mid = (lo + hi) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = convert(lo, mid - 1, nums);
        root.right = convert(mid + 1, hi, nums);
        return root;
    }
}