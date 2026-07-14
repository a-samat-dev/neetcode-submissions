class Solution {

    private var res = 0

    fun findTargetSumWays(nums: IntArray, target: Int): Int {
        findTargetSumWays(nums, target, 0, 0)
        return res
    }

    fun findTargetSumWays(nums: IntArray, target: Int, idx: Int, currSum: Int) {
        if (idx >= nums.size) {
            if (currSum == target) res++
            return
        }
        findTargetSumWays(nums, target, idx + 1, currSum - nums[idx])
        findTargetSumWays(nums, target, idx + 1, currSum + nums[idx])
    }
}