class Solution {
    fun combine(n: Int, k: Int): List<List<Int>> {
        val finalResult: LinkedList<List<Int>> = LinkedList()
        combine(n, 1, k, LinkedList<Int>(), finalResult)

        return finalResult
    }

    private fun combine(n: Int, currN: Int, k: Int, currList: LinkedList<Int>, finalResult: LinkedList<List<Int>>) {
        if (currList.size == k || currN > n) {
            if (currList.size == k)
                finalResult.add(LinkedList(currList))
            return
        }
        combine(n, currN + 1, k, currList, finalResult)
        currList.addLast(currN)
        combine(n, currN + 1, k, currList, finalResult)
        currList.removeLast()
    }
}