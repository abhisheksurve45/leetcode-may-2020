public class KSmallestElementinBST {
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
        public int kthSmallest(TreeNode root, int k) {
            if (root == null) return -1;
            Stack<TreeNode> st = new Stack<>();
            while (true) {
                while (root != null) {
                    st.add(root);
                    root = root.left;
                }
                root = st.pop();
                if (--k == 0) return root.val;
                root = root.right;
            }

        }
    }
}
