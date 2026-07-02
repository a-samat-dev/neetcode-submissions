class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size

        while (left <= right) {
            val mid = (left + right) / 2
            if (mid > nums.size - 1) return -1
            if (nums[mid] == target) return mid
            if (target < nums[mid]) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }

        return -1
    }
}
