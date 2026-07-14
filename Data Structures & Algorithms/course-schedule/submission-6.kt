class Solution {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val inWeightMap = mutableMapOf<Int, Int>()
        val outEdgesMap = mutableMapOf<Int, LinkedList<Int>>()

        for (i in 0 until numCourses) {
            inWeightMap[i] = 0
            outEdgesMap[i] = LinkedList<Int>()
        }

        for (edge in prerequisites) {
            inWeightMap[edge[0]] = inWeightMap[edge[0]]!!.plus(1)
            outEdgesMap[edge[1]]?.add(edge[0])
        }

        val queue = LinkedList<Int>()
        queue.addAll(inWeightMap.entries.filter { it.value == 0 }.map { it.key })
        val completed = HashSet<Int>()

        while (queue.isNotEmpty()) {
            val poll = queue.poll()
            if (completed.contains(poll)) continue
            completed.add(poll)
            val edges = outEdgesMap[poll]!!

            for (edge in edges) {
                inWeightMap[edge] = inWeightMap[edge]!!.minus(1)
                if (inWeightMap[edge] == 0)
                    queue.add(edge)
            }
        }

        return completed.size == numCourses
    }
}