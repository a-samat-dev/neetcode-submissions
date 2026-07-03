/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    private var preIdx = 0

    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        var idxMap = mutableMapOf<Int, Int>()

        for (i in 0..<inorder.size) {
            idxMap[inorder[i]] = i
        }

        return buildTree(preorder, inorder, 0, inorder.size - 1, idxMap)
    }

    fun buildTree(preorder: IntArray, inorder: IntArray, left: Int, right: Int, idxMap: Map<Int, Int>): TreeNode? {
        val node = TreeNode(preorder[preIdx])
        val idx = idxMap[preorder[preIdx]]!!
        preIdx++

        if (idx - 1 >= left) {
            node.left = buildTree(preorder, inorder, left, idx - 1, idxMap)
        }
        if (idx + 1 <= right) {
            node.right = buildTree(preorder, inorder, idx + 1, right, idxMap)
        }

        return node
    }
}
