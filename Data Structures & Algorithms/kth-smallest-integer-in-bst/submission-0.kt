/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun kthSmallest(root: TreeNode?, k: Int): Int {
        val list = mutableListOf<Int>()
        inOrderTraversal(root, list, k)

        return list[k - 1]
    }

    fun inOrderTraversal(node: TreeNode?, list: MutableList<Int>, k: Int) {
        if (list.size == k || node == null) return
        inOrderTraversal(node.left, list, k)
        if (list.size == k) return
        list.add(node.`val`)
        if (list.size == k) return
        inOrderTraversal(node.right, list, k)
        if (list.size == k) return
    }
}
