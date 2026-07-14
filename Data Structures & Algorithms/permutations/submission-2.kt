class Solution {

    fun permute(nums: IntArray): List<List<Int>> {
        val finalResult = LinkedList<LinkedList<Int>>()
        permute(nums, LinkedList(), finalResult, HashSet())
        return finalResult
    }

    fun permute(
        nums: IntArray,
        currList: LinkedList<Int>,
        finalResult: LinkedList<LinkedList<Int>>,
        addedSet: HashSet<Int>
    ) {
        if (currList.size == nums.size) {
            finalResult.add(LinkedList(currList))
            return
        }

        for ((index, value) in nums.withIndex()) {
            if (addedSet.contains(index)) continue
            addedSet.add(index)
            currList.addLast(value)
            permute(nums, currList, finalResult, addedSet)
            addedSet.remove(index)
            currList.removeLast()
        }
    }
}