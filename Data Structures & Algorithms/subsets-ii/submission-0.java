public class Solution {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);
        subsetsWithDup(nums, 0, new LinkedList<>(), res);

        return res;
    }

    public void subsetsWithDup(int[] nums, int idx, List<Integer> currList, List<List<Integer>> res) {
        if (idx == nums.length) {
            res.add(new LinkedList<>(currList));
            return;
        } else if (idx > nums.length) {
            return;
        }

        currList.add(nums[idx]);
        subsetsWithDup(nums, idx + 1, currList, res);
        currList.remove(currList.size() - 1);

        int currNum = nums[idx];
        idx++;

        while (idx < nums.length && nums[idx] == currNum) {
            idx++;
        }

        subsetsWithDup(nums, idx, currList, res);
    }
}
