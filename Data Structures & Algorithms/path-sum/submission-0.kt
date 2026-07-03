/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
        if (root == null) return false
        return hasPathSum(root, targetSum, 0)
    }

    fun hasPathSum(root: TreeNode?, targetSum: Int, currSum: Int): Boolean {
        if (root!!.left == null && root!!.right == null) return targetSum == (currSum + root.`val`)
        if (root.left != null && hasPathSum(root.left, targetSum, currSum + root.`val`)) return true
        if (root.right != null)
            return hasPathSum(root.right, targetSum, currSum + root.`val`)
        return false
    }
}
