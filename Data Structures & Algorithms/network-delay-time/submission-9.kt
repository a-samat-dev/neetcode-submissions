class Solution {
    fun networkDelayTime(times: Array<IntArray>, n: Int, k: Int): Int {
        val distMap = mutableMapOf<Int, Int>()
        val edgesMap = mutableMapOf<Int, LinkedList<IntArray>>()
        val minHeap = PriorityQueue<IntArray> { o1, o2 -> o2[2].compareTo(o1[2]) }

        for (i in 1..n) {
            distMap[i] = if (i != k) Int.MAX_VALUE else 0
            edgesMap[i] = LinkedList<IntArray>()
        }
        for (time in times) {
            edgesMap[time[0]]!!.add(time)
        }

        minHeap.addAll(edgesMap[k]!!)

        while (minHeap.isNotEmpty()) {
            var poll = minHeap.poll()
            val updatedDist = distMap[poll[0]]!!.plus(poll[2])

            if (distMap[poll[1]]!! > updatedDist) {
                distMap[poll[1]] = updatedDist
                minHeap.addAll(edgesMap[poll[1]]!!)
            }
        }
        val max = distMap.values.max()
        return if (max == Int.MAX_VALUE) -1 else max
    }
}