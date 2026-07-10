class NumMatrix(matrix: Array<IntArray>) {

    private val prefixSum = Array(matrix.size + 1) { IntArray(matrix[0].size + 1) }

    init {
        for (i in 0 until matrix.size) {
            val prefix = IntArray(matrix[i].size + 1)
            val currRow = matrix[i]

            for (j in 0 until matrix[0].size) {
                prefix[j + 1] = prefix[j] + currRow[j]

                prefixSum[i + 1][j + 1] = prefix[j + 1] + prefixSum[i][j + 1]
            }
        }
    }

    fun sumRegion(row1: Int, col1: Int, row2: Int, col2: Int): Int {
        var result = prefixSum[row2 + 1][col2 + 1]
        result -= prefixSum[row1][col2 + 1]
        result -= prefixSum[row2 + 1][col1] - prefixSum[row1][col1]

        return result
    }
}