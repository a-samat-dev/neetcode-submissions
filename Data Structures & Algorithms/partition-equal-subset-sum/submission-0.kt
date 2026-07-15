class Solution {

    private val memo = mutableMapOf<String, Boolean>()

    fun canPartition(nums: IntArray): Boolean {
        val totalSum = nums.sum()
        if (totalSum % 2 != 0) return false
        val targetSum = totalSum / 2
        return canPartition(nums, 0, targetSum)
    }

    private fun canPartition(nums: IntArray, idx: Int, targetSum: Int): Boolean {
        if (targetSum == 0) return true
        if (idx >= nums.size) return false
        val key = "$idx - $targetSum"
        if (memo.contains(key)) return memo[key]!!
        val skip = canPartition(nums, idx + 1, targetSum)
        if (skip) {
            memo[key] = true
            return true
        }
        val take = canPartition(nums, idx + 1, targetSum - nums[idx])
        memo[key] = take

        return take
    }
}