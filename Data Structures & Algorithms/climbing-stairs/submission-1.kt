class Solution {

    private var map = mutableMapOf(1 to 1, 2 to 2)

    fun climbStairs(n: Int): Int {
        if (n <= 0) return 0
        if (map.contains(n)) return map[n]!!
        var res = climbStairs(n - 1) + climbStairs(n - 2)
        map[n] = res
        return res
    }
}