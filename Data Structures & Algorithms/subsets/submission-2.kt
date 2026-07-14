class Solution {

    fun subsets(nums: IntArray): List<List<Int>> {
        var finalResult = HashSet<List<Int>>()
        var currList = LinkedList<Int>()
        rec(nums, 0, currList, finalResult)
        return finalResult.toList()
    }

    fun rec(nums: IntArray, idx: Int, currList: LinkedList<Int>, finalResult: HashSet<List<Int>>) {
        if (idx == nums.size) {
            finalResult.add(LinkedList(currList))
            return
        }
        rec(nums, idx + 1, currList, finalResult)
        currList.addLast(nums[idx])
        rec(nums, idx + 1, currList, finalResult)
        currList.removeLast()
    }
}