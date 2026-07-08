class Solution {
    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        var res = Int.MAX_VALUE
        var left = 0
        var right = 0
        var sum = 0

        while (right < nums.size) {
            sum += nums[right++]

            while (left < right && sum >= target) {
                res = min(res, right - left)
                sum -= nums[left++]
            }
        }

        return if (res == Int.MAX_VALUE) 0 else res
    }
}