/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun rightSideView(root: TreeNode?): List<Int> {
        if (root == null) return emptyList()
        var queue = LinkedList<NodeData?>()
        queue.add(NodeData(0, root))
        val list = LinkedList<Int>()
        val addedLevels = mutableSetOf<Int>()

        while (queue.isNotEmpty()) {
            var poll = queue.poll() ?: continue

            if (!addedLevels.contains(poll.level)) {
                list.add(poll.node!!.`val`)
                addedLevels.add(poll.level)
            }

            if (poll.node?.right != null) {
                queue.add(NodeData(poll.level + 1, poll.node.right))
            }
            if (poll.node?.left != null) {
                queue.add(NodeData(poll.level + 1, poll.node.left))
            }
        }

        return list
    }

    data class NodeData(val level: Int, val node: TreeNode?)
}
