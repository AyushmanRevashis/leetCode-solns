
class Pair {
    TreeNode node;
    int level;

    Pair(TreeNode node, int level) {
        this.node = node;
        this.level = level;
    }
}

class Solution {
    static TreeNode target;
    static HashMap<TreeNode, TreeNode> parent;
    static HashSet<TreeNode> infected;

    public int amountOfTime(TreeNode root, int start) {
        parent = new HashMap<>();
        infected = new HashSet<>();
        dfs(root, start);
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(target, 0));
        infected.add(target);

        int minTime = 0;

        while (q.size() > 0) {
            Pair front = q.remove();
            TreeNode node = front.node;
            int level = front.level;

            if (node.left != null && !infected.contains(node.left)) {
                q.add(new Pair(node.left, level + 1));
                infected.add(node.left);
            }
            if (node.right != null && !infected.contains(node.right)) {
                q.add(new Pair(node.right, level + 1));
                infected.add(node.right);
            }
            TreeNode p = parent.get(node);
            if (p != null && !infected.contains(p)) {
                infected.add(p);
                q.add(new Pair(p, level + 1));
            }
            minTime = Math.max(level, minTime);
        }
        return minTime;

    }

    void dfs(TreeNode root, int start) {
        if (root == null)
            return;
        if (root.val == start)
            target = root;
        if (root.left != null)
            parent.put(root.left, root);
        if (root.right != null)
            parent.put(root.right, root);
        dfs(root.left, start);
        dfs(root.right, start);
    }
}