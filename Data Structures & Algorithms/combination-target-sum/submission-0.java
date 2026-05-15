class Solution {

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        combinationSum(nums, 0, result, new ArrayList<>(), target, 0);
        return result;
    }

    public void combinationSum(int[] nums, int idx, List<List<Integer>> result, List<Integer> currList, int target, int currSum) {
        if (currSum == target) {
            result.add(new ArrayList<>(currList));
            return;
        } else if (currSum > target || idx == nums.length) {
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            currSum += nums[i];
            currList.add(nums[i]);
            combinationSum(nums, i, result, currList, target, currSum);
            currSum -= nums[i];
            currList.remove(currList.size() - 1);
        }
    }
}
