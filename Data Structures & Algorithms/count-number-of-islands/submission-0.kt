class Solution {

    private var res: Int = 0

    fun numIslands(grid: Array<CharArray>): Int {
        res = 0
        val visited = HashSet<String>()

        for (i in 0..<grid.size) {
            for (j in 0..<grid[0].size) {
                if (grid[i][j] == '1' && !visited.contains("$i - $j")) {
                    dfs(grid, i, j, visited)
                    res++
                }
            }
        }

        return res
    }

    private fun dfs(grid: Array<CharArray>, row: Int, col: Int, visited: HashSet<String>) {
        if (row < 0 || row >= grid.size || col < 0 || col >= grid[0].size || visited.contains("$row - $col") || grid[row][col] == '0') return
        visited.add("$row - $col")
        dfs(grid, row, col + 1, visited)
        dfs(grid, row + 1, col, visited)
        dfs(grid, row, col - 1, visited)
        dfs(grid, row - 1, col, visited)
    }
}