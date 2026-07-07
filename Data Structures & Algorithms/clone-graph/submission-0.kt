/*
Definition for a Node.
class Node(var `val`: Int) {
    var neighbors: ArrayList<Node?> = ArrayList()
}
*/

class Solution {
    fun cloneGraph(node: Node?): Node? {
        if (node == null) return node
        val nodeMap = mutableMapOf<Int, Node>()
        val queue = LinkedList<Node>()
        queue.add(node)
        val visited = HashSet<Int>()
        var newRoot: Node? = null

        while (queue.isNotEmpty()) {
            val pop = queue.pop()
            if (pop == null || visited.contains(pop.`val`)) continue
            visited.add(pop.`val`)
            val newNode = nodeMap.getOrDefault(pop.`val`, Node(pop.`val`))
            nodeMap[pop.`val`] = newNode
            newRoot = newRoot ?: newNode

            for (n in pop.neighbors) {
                val newN = nodeMap.getOrDefault(n!!.`val`, Node(n.`val`))
                nodeMap[newN.`val`] = newN
                newNode.neighbors.add(newN)
                queue.add(n)
            }

        }

        return newRoot
    }
}