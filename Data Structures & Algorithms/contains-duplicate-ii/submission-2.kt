class Solution {
    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        val set = mutableMapOf<Int, Int>()
        set[nums[0]] = 0
        var right = 1

        while (right < nums.size) {
            if (set.containsKey(nums[right])) {
                if (right - set[nums[right]]!! <= k) return true
            }
            set[nums[right]] = right
            right++
        }

        return false
    }
}