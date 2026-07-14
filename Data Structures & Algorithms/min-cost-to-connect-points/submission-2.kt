class Solution {
    fun minCostConnectPoints(points: Array<IntArray>): Int {
        var result = 0
        val edgesMap = mutableMapOf<String, LinkedList<IntArray>>()
        val visited = mutableSetOf<String>()
        val minHeap = PriorityQueue<IntArray> { o1, o2 ->
            o1[4].compareTo(o2[4])
        }

        for (mainPoint in points) {
            val v1Key = "${mainPoint[0]} - ${mainPoint[1]}"
            edgesMap.putIfAbsent(v1Key, LinkedList<IntArray>())

            for (point in points) {
                if (mainPoint.contentEquals(point)) continue
                val dist = abs(mainPoint[0] - point[0]) + abs(mainPoint[1] - point[1])
                edgesMap[v1Key]!!.add(intArrayOf(mainPoint[0], mainPoint[1], point[0], point[1], dist))
            }
        }

        val random = edgesMap.keys.random()
        visited.add(random)
        minHeap.addAll(edgesMap[random]!!)

        while (minHeap.isNotEmpty() && visited.size < edgesMap.keys.size) {
            var poll = minHeap.poll()
            val key1 = "${poll[0]} - ${poll[1]}"
            val key2 = "${poll[2]} - ${poll[3]}"
            if (visited.contains(key1) && visited.contains(key2)) continue
            if (visited.contains(key1)) {
                visited.add(key2)
                minHeap.addAll(edgesMap[key2]!!)
            } else if (!visited.contains(key1) && !visited.contains(key2)) {
                visited.add(key1)
                minHeap.addAll(edgesMap[key1]!!)
            } else {
                visited.add(key1)
                minHeap.addAll(edgesMap[key1]!!)
            }

            result += poll[4]
        }

        return result
    }
}