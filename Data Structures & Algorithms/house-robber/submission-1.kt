class Solution {
    fun rob(nums: IntArray): Int {
        if (nums.size == 1) return nums[0]
        if (nums.size < 3) return max(nums[0], nums[1])
        nums[1] = max(nums[0], nums[1])

        for (i in 2..<nums.size) {
            nums[i] = max(nums[i - 1], nums[i - 2] + nums[i])
        }

        return max(nums[nums.size - 2], nums[nums.size - 1])
    }
}