class Solution {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var left = 0
        var right = numbers.size - 1
        var currSum = numbers[left] + numbers[right]

        while (left < right) {
            currSum = numbers[left] + numbers[right]

            if (currSum < target) {
                left++
            } else if (currSum > target) {
                right--
            } else {
                break
            }
        }

        return intArrayOf(left + 1, right + 1)
    }
}