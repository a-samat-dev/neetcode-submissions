/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun insertIntoBST(root: TreeNode?, `val`: Int): TreeNode? {
        if (root == null) return TreeNode(`val`)
        var curr = root!!

        while (true) {
            if (`val` < curr.`val`) {
                if (curr.left == null) {
                    curr.left = TreeNode(`val`)
                    break
                } else {
                    curr = curr.left!!
                }
            } else if (`val` > curr.`val`) {
                if (curr.right == null) {
                    curr.right = TreeNode(`val`)
                    break
                } else {
                    curr = curr.right!!
                }
            }
        }

        return root
    }
}