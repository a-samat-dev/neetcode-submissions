/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val list = mutableListOf<List<Int>>()
        var queue = LinkedList<TreeNode?>()
        queue.add(root)

        while (queue.isNotEmpty()) {
            val tempQueue = LinkedList<TreeNode?>()
            val currList = mutableListOf<Int>()

            while (queue.isNotEmpty()) {
                val poll = queue.removeFirst() ?: continue
                currList.add(poll.`val`)
                tempQueue.add(poll.left)
                tempQueue.add(poll.right)
            }

            if (currList.isNotEmpty()) list.add(currList)
            queue = tempQueue
        }

        return list
    }
}
