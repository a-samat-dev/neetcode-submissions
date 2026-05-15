class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        subsetsRecursive(res, 0, nums, new LinkedList<>());

        return res;
    }

    private void subsetsRecursive(List<List<Integer>> res, int idx, int[] nums, List<Integer> currList) {
        if (idx == nums.length) {
            res.add(new LinkedList<>(currList));
            return;
        }

        currList.add(nums[idx]);
        subsetsRecursive(res, idx + 1, nums, currList);
        currList.remove(currList.size() - 1);

        subsetsRecursive(res, idx + 1, nums, currList);
    }
}
