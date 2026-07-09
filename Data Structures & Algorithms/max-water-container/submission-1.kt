class Solution {
    fun maxArea(heights: IntArray): Int {
        var left = 0
        var right = heights.size - 1
        var res = 0

        while (left < right) {
            res = max(res, (right - left) * min(heights[left], heights[right]))

            if (heights[left] < heights[right]) {
                left++
            } else {
                right--
            }
        }

        return res
    }
}