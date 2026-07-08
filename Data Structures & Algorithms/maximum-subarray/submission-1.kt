class Solution {
    fun maxSubArray(nums: IntArray): Int {
        var res = nums[0]
        var currSum = nums[0]

        for (i in 1..<nums.size) {
            val n = nums[i]

            if (currSum < 0) {
                currSum = 0
            }

            currSum += n
            res = max(res, currSum)
        }

        return res
    }
}