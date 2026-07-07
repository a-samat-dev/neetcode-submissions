class Solution {
    fun longestCommonSubsequence(text1: String, text2: String): Int {
        val arr = Array(text1.length + 1) { IntArray(text2.length + 1) }

        for (row in 1..<arr.size) {
            val c1 = text1[row - 1]

            for (col in 1..<arr[0].size) {
                val c2 = text2[col - 1]

                if (c1 == c2) {
                    arr[row][col] = arr[row - 1][col - 1] + 1
                } else {
                    arr[row][col] = max(arr[row - 1][col], arr[row][col - 1])
                }
            }
        }

        return arr[text1.length][text2.length]
    }
}