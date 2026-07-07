class Solution {
    fun orangesRotting(grid: Array<IntArray>): Int {
        val queue = LinkedList<Triple<Int, Int, Int>>()
        val visited = HashSet<String>()
        var res = 0

        for (row in 0..<grid.size) {
            for (col in 0..<grid[0].size) {
                if (grid[row][col] == 2) queue.add(Triple(row, col, 0))
            }
        }

        while (queue.isNotEmpty()) {
            var pop = queue.pop()
            var row = pop.component1()
            var col = pop.component2()
            var minutes = pop.component3()

            if (row < 0 || row >= grid.size || col < 0 || col >= grid[0].size || visited.contains("$row - $col")
                || grid[row][col] == 0
            ) continue
            visited.add("$row - $col")
            grid[row][col] = 2
            res = max(res, minutes)
            queue.add(Triple(row, col + 1, minutes + 1))
            queue.add(Triple(row + 1, col, minutes + 1))
            queue.add(Triple(row, col - 1, minutes + 1))
            queue.add(Triple(row - 1, col, minutes + 1))
        }

        for (nums in grid) {
            for (n in nums) {
                if (n == 1) return -1
            }
        }

        return res
    }
}