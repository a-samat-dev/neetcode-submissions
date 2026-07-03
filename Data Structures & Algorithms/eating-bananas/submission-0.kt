class Solution {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {
        var right = piles.max()
        var res = Int.MAX_VALUE
        var left = 1

        while (left <= right) {
            val mid = (left + right) / 2
            if (check(piles, h, mid)) {
                res = mid
                right = mid - 1
            } else {
                left = mid + 1
            }
        }

        return res
    }

    private fun check(piles: IntArray, h: Int, curr: Int): Boolean {
        var hoursSpent = 0

        for (pile in piles) {
            hoursSpent += (pile / curr + if (pile % curr == 0) 0 else 1)
        }

        return hoursSpent <= h
    }
}