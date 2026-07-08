class Solution {
    fun numOfSubarrays(arr: IntArray, k: Int, threshold: Int): Int {
        var res = 0
        var left = 0
        var right = 0
        var sum = 0.0

        while (right < arr.size) {
            sum += arr[right++]

            if (right - left < k) {
                continue
            }
            if (sum / (right - left) >= threshold) {
                res++
            }
            sum -= arr[left++]
        }

        return res
    }
}