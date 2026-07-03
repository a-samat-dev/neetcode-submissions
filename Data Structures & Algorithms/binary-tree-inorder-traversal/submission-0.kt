/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
 
class Solution {
    fun inorderTraversal(root: TreeNode?): List<Int> {
        val list = mutableListOf<Int>()
        inorderTraversal(root, list)

        return list
    }

    fun inorderTraversal(root: TreeNode?, list: MutableList<Int>) {
        if (root == null) return
        inorderTraversal(root.left, list)
        list.add(root.`val`)
        inorderTraversal(root.right, list)
    }
}
