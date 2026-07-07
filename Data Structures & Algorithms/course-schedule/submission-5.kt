class Solution {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        if (prerequisites.isEmpty()) return true
        val edgesMap = mutableMapOf<Int, LinkedList<Int>>()
        val inDegreeMap = mutableMapOf<Int, Int>()
        val completed = mutableSetOf<Int>()

        for (i in 0..<numCourses) {
            inDegreeMap[i] = 0
            edgesMap[i] = LinkedList<Int>()
        }

        for (prerequisite in prerequisites) {
            inDegreeMap[prerequisite[0]] = inDegreeMap[prerequisite[0]]!!.plus(1)
            edgesMap[prerequisite[1]]!!.add(prerequisite[0])
        }

        val queue = LinkedList<Int>()
        queue.addAll(inDegreeMap.entries.filter { it.value == 0 }.map { it.key })

        while (queue.isNotEmpty()) {
            var pop = queue.pop()
            var edges = edgesMap[pop]!!
            completed.add(pop)

            for (edge in edges) {
                inDegreeMap[edge] = inDegreeMap[edge]!!.minus(1)

                if (inDegreeMap[edge] == 0) queue.add(edge)
            }
        }

        return completed.size == numCourses
    }
}