import java.util.*
import kotlin.math.min

class Solution {
    fun shortestPathBinaryMatrix(grid: Array<IntArray>): Int {
        val visited = HashSet<String>()
        var res = Int.MAX_VALUE
        val queue = LinkedList<Triple<Int, Int, Int>>()
        queue.add(Triple(0, 0, 1))

        while (queue.isNotEmpty()) {
            val pop = queue.pop()
            val row = pop.component1()
            val col = pop.component2()
            val path = pop.component3()

            if (row < 0 || row >= grid.size || col < 0 || col >= grid[0].size
                || visited.contains("$row - $col") || grid[row][col] != 0
            ) continue
            visited.add("$row - $col")
            if (row == grid.size - 1 && col == grid[0].size - 1) {
                res = min(path, path + 1)
                continue
            }
            queue.add(Triple(row, col + 1, path + 1))
            queue.add(Triple(row + 1, col + 1, path + 1))
            queue.add(Triple(row + 1, col, path + 1))
            queue.add(Triple(row + 1, col - 1, path + 1))
            queue.add(Triple(row, col - 1, path + 1))
            queue.add(Triple(row - 1, col - 1, path + 1))
            queue.add(Triple(row - 1, col, path + 1))
            queue.add(Triple(row - 1, col + 1, path + 1))
        }

        return if (res == Int.MAX_VALUE) -1 else res
    }
}