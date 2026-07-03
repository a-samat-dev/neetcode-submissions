/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun deleteNode(root: TreeNode?, key: Int): TreeNode? {
        if (root == null) return root
        var prev: TreeNode? = null
        var curr: TreeNode? = root
        var finalRoot = root

        while (curr != null) {
            if (curr.`val` == key) {
                var replacement = if (curr.left != null) getLeftClosest(curr.left) else getRightClosest(curr.right)

                if (curr.left != null) {
                    replacement?.left = if (replacement === curr.left) null else curr.left
                    replacement?.right = curr.right
                } else if (curr.right != null) {
                    replacement?.left = curr.left
                    replacement?.right = if (replacement === curr.right) null else curr.right
                }

                finalRoot = if (finalRoot?.`val` == key) replacement else root

                if (prev?.left?.`val` == key) {
                    prev.left = replacement
                } else {
                    prev?.right = replacement
                }
                break
            } else if (key < curr.`val`) {
                prev = curr
                curr = curr.left
            } else {
                prev = curr
                curr = curr.right
            }
        }

        return finalRoot
    }

    fun getRightClosest(node: TreeNode?): TreeNode? {
        if (node?.left == null) return node
        var prev = node
        var curr = node.left

        while (curr?.left != null) {
            prev = curr
            curr = curr.left
        }

        prev.left = null

        return curr
    }

    fun getLeftClosest(node: TreeNode?): TreeNode? {
        if (node?.right == null) return node
        var prev = node
        var curr = node.right

        while (curr?.right != null) {
            prev = curr
            curr = curr.right
        }

        prev.right = null

        return curr
    }
}
