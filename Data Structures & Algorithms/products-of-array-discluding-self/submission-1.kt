class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        var prefix = IntArray(nums.size)
        var suffix = IntArray(nums.size)

        for (i in 0 until nums.size) {
            prefix[i] = (if (i == 0) 1 else prefix[i - 1]).times(nums[i])
        }
        for (i in nums.size - 1 downTo 0) {
            suffix[i] = (if (i == nums.size - 1) 1 else suffix[i + 1]).times(nums[i])
        }
        for (i in 0 until nums.size) {
            val leftProduct = if (i == 0) 1 else prefix[i - 1]
            val rightProduct = if (i == nums.size - 1) 1 else suffix[i + 1]
            nums[i] = leftProduct * rightProduct
        }

        return nums
    }
}