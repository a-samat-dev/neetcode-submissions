class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        var left = 0
        var right = matrix.size * matrix[0].size - 1

        while (left <= right) {
            val mid = (left + right) / 2
            val row = mid / matrix[0].size
            val col = mid % matrix[0].size

            if (matrix[row][col] == target) return true
            if (target < matrix[row][col]) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }

        return false
    }
}
