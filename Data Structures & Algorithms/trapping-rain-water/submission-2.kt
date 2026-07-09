class Solution {
    fun trap(height: IntArray): Int {
        if (height.size < 3) return 0
        var prefixHeight = IntArray(height.size)
        prefixHeight[0] = height[0]
        var suffixHeight = IntArray(height.size)
        suffixHeight[suffixHeight.size - 1] = height[height.size - 1]
        var res = 0

        for (i in 1 until height.size) {
            prefixHeight[i] = max(prefixHeight[i - 1], height[i])
        }
        for (i in height.size - 2 downTo 0) {
            suffixHeight[i] = max(suffixHeight[i + 1], height[i])
        }
        for (i in 0 until height.size) {
            res += min(prefixHeight[i], suffixHeight[i]) - height[i]
        }

        return res
    }
}
