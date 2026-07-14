class MedianFinder {

    private val minHeap = PriorityQueue<Int>()
    private val maxHeap = PriorityQueue<Int> { o1, o2 -> o2.compareTo(o1) }

    fun addNum(num: Int) {
        maxHeap.add(num)

        if (maxHeap.size - minHeap.size > 1) {
            minHeap.add(maxHeap.poll())
        } else if (minHeap.isNotEmpty() && maxHeap.peek() > minHeap.peek()) {
            val n1 = maxHeap.poll()
            val n2 = minHeap.poll()
            maxHeap.add(n2)
            minHeap.add(n1)
        }
    }

    fun findMedian(): Double {
        if (minHeap.size == maxHeap.size) return minHeap.peek().toDouble().plus(maxHeap.peek().toDouble()).div(2.0)
        if (minHeap.size > maxHeap.size) return minHeap.peek().toDouble()
        return maxHeap.peek().toDouble()
    }
}