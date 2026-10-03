/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 class Pair{
    long max;
    long min;
    Pair(long max,long min){
        this.max=max;
        this.min=min;
    }
 }
class Solution {
    static boolean flag;
    public boolean isValidBST(TreeNode root) {
        flag= true;
        maxMin(root);
        return flag;
    }
    Pair maxMin(TreeNode root){
        if(root==null) return new Pair(Long.MIN_VALUE,Long.MAX_VALUE);
        Pair left= maxMin(root.left);
        Pair right= maxMin(root.right);
        long max= Math.max(root.val,Math.max(left.max,right.max));
        long min= Math.min(root.val,Math.min(left.min,right.min));
        if(root.val<=left.max || root.val>=right.min) flag=false;
        return new Pair(max,min);
    }
}