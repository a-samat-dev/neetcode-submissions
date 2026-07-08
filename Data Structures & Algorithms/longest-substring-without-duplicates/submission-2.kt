class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        val set = mutableSetOf<Char>()
        var res = 0
        var left = 0
        var right = 0

        while (right < s.length) {
            while (set.contains(s[right])) {
                set.remove(s[left++])
            }
            set.add(s[right++])
            res = max(res, right.minus(left))
        }

        return res
    }
}