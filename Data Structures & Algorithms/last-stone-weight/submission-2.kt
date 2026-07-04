class Solution {

    fun lastStoneWeight(stones: IntArray): Int {
        if (stones.size == 1) return stones[0]
        var maxHeap = PriorityQueue<Int> { a, b -> b.compareTo(a) }
        maxHeap.addAll(stones.toList())

        while (maxHeap.size > 1) {
            val pop1 = maxHeap.poll()
            val pop2 = maxHeap.poll()
            var abs = abs(pop1.minus(pop2))
            maxHeap.add(abs)
        }

        return maxHeap.peek()
    }
}