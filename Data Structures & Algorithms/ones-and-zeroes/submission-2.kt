class Solution {

    private lateinit var strs: Array<String>
    private lateinit var occMap: MutableMap<Int, IntArray>
    private val memo = mutableMapOf<String, Int>()

    fun findMaxForm(strs: Array<String>, m: Int, n: Int): Int {
        this.strs = strs
        this.occMap = mutableMapOf<Int, IntArray>()

        for ((index, value) in strs.withIndex()) {
            this.occMap.putIfAbsent(index, IntArray(2))

            for (c in value) {
                if (c == '0')
                    this.occMap[index]!![0] = this.occMap[index]!![0] + 1
                else
                    this.occMap[index]!![1] = this.occMap[index]!![1] + 1
            }
        }

        return findMaxForm(0, m, n)
    }

    fun findMaxForm(idx: Int, m: Int, n: Int): Int {
        if (m < 0 || n < 0 || idx >= this.strs.size) return 0
        val key = "$idx - $m - $n"
        if (memo.contains(key)) return memo[key]!!
        var max = findMaxForm(idx + 1, m, n)
        val count = this.occMap[idx]!!

        if (count[0] <= m && count[1] <= n)
            max = max(max, 1 + findMaxForm(idx + 1, m - count[0], n - count[1]))

        memo[key] = max

        return max
    }
}