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
class Solution {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        Set<Integer> processed = new HashSet<>();

        while (!stack.isEmpty()) {
            TreeNode peek = stack.peek();

            if ((peek.left != null || peek.right != null) && !processed.contains(peek.val)) {
                processed.add(peek.val);
                if (peek.right != null) stack.add(peek.right);
                if (peek.left != null) stack.add(peek.left);
            } else {
                result.add(stack.pop().val);
            }
        }

        return result;
    }
}