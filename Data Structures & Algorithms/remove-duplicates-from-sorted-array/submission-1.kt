class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        var left = 0
        var right = 0
        var res = 1

        while (right < nums.size) {
            if (nums[left] == nums[right]) {
                right++
            } else {
                nums[++left] = nums[right]
                res++
            }
        }

        return res
    }
}