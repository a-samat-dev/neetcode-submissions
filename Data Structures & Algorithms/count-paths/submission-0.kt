class Solution {
    fun uniquePaths(m: Int, n: Int): Int {
        val arr = Array(m) { IntArray(n) }
        arr[0][0] = 1

        for (row in 0..<m) {
            for (col in 0..<n) {
                if (row == 0 && col == 0) continue
                val top = if (row - 1 >= 0) arr[row - 1][col] else 0
                val left = if (col - 1 >= 0) arr[row][col - 1] else 0
                arr[row][col] = top + left
            }
        }

        return arr[arr.size - 1][arr[0].size - 1]
    }
}