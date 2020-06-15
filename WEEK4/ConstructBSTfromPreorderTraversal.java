public class ConstructBSTfromPreorderTraversal {
    /**
     * Question : https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/537/week-4-may-22nd-may-28th/3339/
     */
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
        int index = 0;

        public TreeNode bstFromPreorder(int[] preorder) {
            if (preorder == null || preorder.length == 0) return null;
            return constructBstFromPreorder(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        public TreeNode constructBstFromPreorder(int[] preorder, int start, int end) {
            if (index >= preorder.length) return null;

            TreeNode root = null;
            int key = preorder[index];

            if (key > start && key < end) {
                root = new TreeNode(key);
                index++;
                root.left = constructBstFromPreorder(preorder, start, key);
                root.right = constructBstFromPreorder(preorder, key, end);
            }

            return root;
        }
    }
}
