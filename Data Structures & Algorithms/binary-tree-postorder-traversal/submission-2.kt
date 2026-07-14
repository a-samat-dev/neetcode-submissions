class Solution {
    fun postorderTraversal(root: TreeNode?): List<Int> {
        if (root == null) return emptyList()
        val stack = LinkedList<TreeNode>()
        val res = mutableListOf<Int>()
        val visited = mutableSetOf<Int>()
        stack.addLast(root)

        while (stack.isNotEmpty()) {
            val peek = stack.peekLast()
            if (peek.left == null && peek.right == null) {
                res.add(stack.removeLast().`val`)
                continue
            }
            if (visited.contains(peek.`val`)) {
                res.add(stack.removeLast().`val`)
                continue
            }
            visited.add(peek.`val`)
            if (peek.right != null) {
                stack.addLast(peek.right!!)
            }
            if (peek.left != null) {
                stack.addLast(peek.left!!)
            }
        }

        return res
    }
}