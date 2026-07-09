class NumArray(nums: IntArray) {

    private var prefixSum = IntArray(nums.size)

    init {
        for (i in 0 until nums.size) {
            prefixSum[i] = nums[i] + if (i > 0) prefixSum[i - 1] else 0
        }
    }

    fun sumRange(left: Int, right: Int): Int {
        return if (left == 0) prefixSum[right] else prefixSum[right] - prefixSum[left - 1]
    }
}