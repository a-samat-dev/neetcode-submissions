class Solution {

    fun combinationSum(nums: IntArray, target: Int): List<List<Int>> {
        val finalResult: HashSet<List<Int>> = HashSet()
        combinationSum(nums, target, 0, LinkedList<Int>(), 0, finalResult)

        return finalResult.toList()
    }

    fun combinationSum(
        nums: IntArray,
        target: Int,
        currIdx: Int,
        currList: LinkedList<Int>,
        currSum: Int,
        finalResult: HashSet<List<Int>>
    ) {
        if (currIdx >= nums.size || currSum >= target) {
            if (currSum == target)
                finalResult.add(LinkedList(currList)) // n
            return
        }
        combinationSum(nums, target, currIdx + 1, currList, currSum, finalResult)
        currList.addLast(nums[currIdx])
        combinationSum(nums, target, currIdx, currList, currSum + nums[currIdx], finalResult)
        combinationSum(nums, target, currIdx + 1, currList, currSum + nums[currIdx], finalResult)
        currList.removeLast()
    }
}