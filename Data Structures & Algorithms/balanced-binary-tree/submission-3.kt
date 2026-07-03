/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun isBalanced(root: TreeNode?): Boolean {
        try {
            isBalancedRec(root)
        } catch (e: IllegalArgumentException) {
            return false
        }

        return true
    }

    fun isBalancedRec(root: TreeNode?): Int {
        if (root == null) return 0
        val left = isBalancedRec(root.left)
        val right = isBalancedRec(root.right)

        if (abs(left.minus(right)) > 1) throw IllegalArgumentException()

        return 1 + max(left, right)
    }
}
