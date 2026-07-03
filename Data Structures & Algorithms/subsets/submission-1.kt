class Solution {
    fun subsets(nums: IntArray): List<List<Int>> {
        val list = mutableListOf<List<Int>>(mutableListOf())
        subsets(nums, list, 0)

        return list
    }

    fun subsets(nums: IntArray, currList: MutableList<List<Int>>, idx: Int) {
        if (idx == nums.size) return
        val listToAppend: MutableList<List<Int>> = mutableListOf()

        for (list in currList) {
            val copy = list.toMutableList()
            copy.add(nums[idx])
            listToAppend.add(copy)
        }

        currList.addAll(listToAppend)
        subsets(nums, currList, idx + 1)
    }
}