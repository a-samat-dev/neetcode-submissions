class KthLargest(k: Int, nums: IntArray) {

    private var maxHeap: PriorityQueue<Int> = PriorityQueue<Int>()
    private var size: Int = 0

    init {
        maxHeap.addAll(nums.toList())
        size = k
        while (maxHeap.size > k) {
            maxHeap.poll()
        }
    }

    fun add(`val`: Int): Int {
        this.maxHeap.add(`val`)
        while (maxHeap.size > this.size) {
            maxHeap.poll()
        }
        return this.maxHeap.peek()
    }
}