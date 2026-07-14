class Solution {
    fun preorderTraversal(root: TreeNode?): List<Int> {
        if (root == null) return emptyList()
        val result = mutableListOf<Int>()
        val stack = LinkedList<TreeNode>()
        stack.add(root)

        while (stack.isNotEmpty()) {
            val pop = stack.removeLast()
            result.add(pop.`val`)
            if (pop.right != null)
                stack.addLast(pop.right!!)
            if (pop.left != null)
                stack.addLast(pop.left!!)
        }

        return result
    }
}