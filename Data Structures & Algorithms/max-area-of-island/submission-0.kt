class Solution {
    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        var res = 0
        val visited = HashSet<String>()

        for (row in 0..<grid.size) {
            for (col in 0..<grid[0].size) {
                if (grid[row][col] == 1 && !visited.contains("$row - $col")) {
                    res = max(res, getArea(grid, row, col, visited))
                }
            }
        }

        return res
    }

    private fun getArea(grid: Array<IntArray>, row: Int, col: Int, visited: HashSet<String>): Int {
        if (row < 0 || row >= grid.size || col < 0 || col >= grid[0].size || visited.contains("$row - $col") || grid[row][col] == 0) return 0
        visited.add("$row - $col")
        var res = 1
        res += getArea(grid, row, col + 1, visited)
        res += getArea(grid, row + 1, col, visited)
        res += getArea(grid, row, col - 1, visited)
        res += getArea(grid, row - 1, col, visited)
        return res
    }
}