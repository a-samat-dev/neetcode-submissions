class Solution {
    fun findDuplicate(nums: IntArray): Int {
        var slow = nums[0]
        var fast = nums[nums[0]]

        while (true) {
            if (slow == fast) {
                var slow2 = 0
                while (slow != slow2) {
                    slow = nums[slow]
                    slow2 = nums[slow2]
                }
                return slow
            }
            slow = nums[slow]
            fast = nums[nums[fast]]
        }
    }
}