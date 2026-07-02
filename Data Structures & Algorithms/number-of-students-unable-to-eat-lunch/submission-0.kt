class Solution {
    fun countStudents(students: IntArray, sandwiches: IntArray): Int {
        var studentsQueue = LinkedList<Int>()
        var sandwichesQueue = LinkedList<Int>()
        studentsQueue.addAll(students.toList())
        sandwichesQueue.addAll(sandwiches.toList())

        while (true) {
            var sandwicheTaken = false
            var studentsSize = studentsQueue.size

            while (studentsSize > 0) {
                var poll = studentsQueue.poll()
                if (poll == sandwichesQueue.peek()) {
                    sandwichesQueue.poll()
                    sandwicheTaken = true
                } else {
                    studentsQueue.add(poll)
                }
                studentsSize--
            }

            if (!sandwicheTaken) break
        }

        return studentsQueue.size
    }
}