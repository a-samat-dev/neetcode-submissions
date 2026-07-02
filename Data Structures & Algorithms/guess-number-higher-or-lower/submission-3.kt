/**
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return       -1 if num is higher than the picked number
 *                1 if num is lower than the picked number
 *               otherwise return 0
 * fun guess(num: Int): Int
 */

class Solution : GuessGame() {
    fun guessNumber(n: Int): Int {
        var left: Long = 0
        var right: Long = n.toLong()

        while (left <= right) {
            val mid = (left + right) / 2
            val res = guess(mid.toInt())

            if (res == 0) return mid.toInt()
            else if (res < 0) right = mid - 1
            else left = mid + 1
        }

        return -1
    }
}
