class Solution {
    fun pivotIndex(nums: IntArray): Int {
        for (i in 1 until nums.size) {
            nums[i] = nums[i - 1] + nums[i]
        }

        for (i in 0 until nums.size) {
            var leftSum = if (i == 0) 0 else nums[i - 1]
            var rightSum = if (i == nums.size - 1) 0 else (nums[nums.size - 1] - nums[i])
            if (leftSum == rightSum) return i
        }

        return -1
    }
}