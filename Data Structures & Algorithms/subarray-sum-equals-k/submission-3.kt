class Solution {
    fun subarraySum(nums: IntArray, k: Int): Int {
        val prefix = IntArray(nums.size)
        var result = 0
        val map = mutableMapOf(0 to 1)

        for (i in 0 until nums.size) {
            prefix[i] = (if (i == 0) 0 else prefix[i - 1]).plus(nums[i])
        }

        for (i in 0 until nums.size) {
            var rem = prefix[i] - k
            result += map.getOrDefault(rem, 0)
            map[prefix[i]] = 1 + map.getOrDefault(prefix[i], 0)
        }

        return result
    }
}