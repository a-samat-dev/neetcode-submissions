class Solution {

    fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
        if (obstacleGrid[0][0] == 1) return 0
        val arr = Array(obstacleGrid.size) { IntArray(obstacleGrid[0].size) }
        arr[0][0] = 1

        for (row in 0..<arr.size) {
            for (col in 0..<arr[0].size) {
                if (row == 0 && col == 0 || obstacleGrid[row][col] == 1) continue
                val top = if (row - 1 >= 0) arr[row - 1][col] else 0
                val left = if (col - 1 >= 0) arr[row][col - 1] else 0
                arr[row][col] = top + left
            }
        }

        return arr[arr.size - 1][arr[0].size - 1]
    }
}