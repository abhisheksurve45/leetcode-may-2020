public class CousinsinBinaryTree {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        Map<Integer, Integer> depth;
        Map<Integer, TreeNode> parentMap;

        private void dfs(TreeNode root, TreeNode parent) {
            if (root == null) return;

            depth.put(root.val, depth.getOrDefault(parent == null ? 0 : parent.val, 0) + 1);
            parentMap.put(root.val, parent);

            dfs(root.left, root);
            dfs(root.right, root);
        }

        public boolean isCousins(TreeNode root, int x, int y) {
            if (root == null) return false;

            depth = new HashMap<>();
            parentMap = new HashMap<>();

            dfs(root, null);

            return depth.get(x) == depth.get(y) && parentMap.get(x) != parentMap.get(y);

        }
    }
}
