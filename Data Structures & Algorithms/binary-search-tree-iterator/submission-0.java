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
class BSTIterator {

    private TreeNode node;

    public BSTIterator(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        List<Integer> list = new LinkedList<>();
        Set<Integer> processed = new HashSet<>();

        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();

            if (pop.left != null && !processed.contains(pop.val)) {
                stack.add(pop);
                stack.add(pop.left);
                processed.add(pop.val);
            } else {
                list.add(pop.val);

                if (pop.right != null) {
                    stack.add(pop.right);
                }
            }
        }

        TreeNode currNode = null;

        for (Integer i : list) {
            if (this.node == null) {
                this.node = new TreeNode(i);
                currNode = this.node;
            } else {
                currNode.right = new TreeNode(i);
                currNode = currNode.right;
            }
        }
    }

    public int next() {
        int res = this.node.val;
        this.node = this.node.right;
        return res;
    }

    public boolean hasNext() {
        return node != null;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */