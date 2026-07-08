class Solution {
    fun characterReplacement(s: String, k: Int): Int {
        val count = mutableMapOf<Char, Int>()
        var res = 0
        var l = 0
        var maxf = 0

        for (r in s.indices) {
            count[s[r]] = count.getOrDefault(s[r], 0) + 1
            maxf = maxOf(maxf, count[s[r]]!!)

            while (r - l - maxf >= k) {
                count[s[l]] = count[s[l]]!! - 1
                l++
            }

            res = maxOf(res, r - l + 1)
        }

        return res
    }
}