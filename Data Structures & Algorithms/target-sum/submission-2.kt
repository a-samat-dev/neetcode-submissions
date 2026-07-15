class Solution {

    private var memo = mutableMapOf<String, Int>()

    fun findTargetSumWays(nums: IntArray, target: Int): Int {
        return findTargetSumWays(nums, target, 0, 0)
    }

    fun findTargetSumWays(nums: IntArray, target: Int, idx: Int, currSum: Int): Int {
        if (idx >= nums.size) {
            if (currSum == target) return 1
            return 0
        }
        val key = "$idx - $currSum"
        if (memo.contains(key)) return memo[key]!!
        var res = findTargetSumWays(nums, target, idx + 1, currSum + nums[idx]) +
                findTargetSumWays(nums, target, idx + 1, currSum - nums[idx])
        memo[key] = res
        return res
    }
}