class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        var heap = PriorityQueue<Int>()

        for (n in nums) {
            heap.add(n)

            if (heap.size > k)
                heap.poll()
        }

        return heap.poll()
    }
}
