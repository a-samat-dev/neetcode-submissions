class Solution {

    fun canPartition(nums: IntArray): Boolean {
        val totalSum = nums.sum()
        if (totalSum % 2 != 0) return false
        val targetSum = totalSum / 2
        var dp = Array(nums.size + 1) { BooleanArray(targetSum + 1) }
        for (i in 0 until dp.size) dp[i][0] = true

        for (row in 1 until dp.size) {
            for (col in 1 until dp[0].size) {
                if (dp[row - 1][col] || col < nums[row - 1]) {
                    dp[row][col] = dp[row - 1][col]
                } else {
                    dp[row][col] = dp[row - 1][col - nums[row - 1]]
                }
            }
        }

        return dp[dp.size - 1][dp[0].size - 1]
    }
}