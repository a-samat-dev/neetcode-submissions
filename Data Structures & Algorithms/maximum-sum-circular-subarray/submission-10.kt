class Solution {
    fun maxSubarraySumCircular(nums: IntArray): Int {
        var globalMax = nums[0]
        var globalMin = nums[0]
        var currMax = 0
        var currMin = 0
        var total = 0

        for (n in nums) {
            total += n
            currMax = max(currMax + n, n)
            currMin = min(currMin + n, n)
            globalMax = max(globalMax, currMax)
            globalMin = min(globalMin, currMin)
        }

        if (globalMax <= 0) return globalMax
        return max(globalMax, total.minus(globalMin))
    }
}