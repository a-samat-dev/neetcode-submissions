class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val result = IntArray(nums.size)
        val prefixProduct = IntArray(nums.size)
        val suffixProduct = IntArray(nums.size)

        for (i in 0..<nums.size) {
            prefixProduct[i] = nums[i].times(if (i == 0) 1 else prefixProduct[i - 1])
            suffixProduct[nums.size - i - 1] =
                nums[nums.size - i - 1].times(if (nums.size - i == nums.size) 1 else suffixProduct[nums.size - i])
        }

        for (i in 0..<nums.size) {
            val prefix = if (i == 0) 1 else prefixProduct[i - 1]
            val suffix = if (i == nums.size - 1) 1 else suffixProduct[i + 1]
            result[i] = prefix.times(suffix)
        }

        return result
    }
}
