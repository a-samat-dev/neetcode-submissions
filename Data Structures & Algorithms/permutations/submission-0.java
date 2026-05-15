class Solution {

    public List<List<Integer>> permute(int[] nums) {
        return permute(nums, 0);
    }

    public List<List<Integer>> permute(int[] nums, int idx) {
        List<List<Integer>> res = new LinkedList<>();

        if (idx >= nums.length) {
            res.add(new LinkedList<>());
            return res;
        }

        List<List<Integer>> permutations = permute(nums, idx + 1);

        for (List<Integer> permutation : permutations) {
            for (int i = 0; i < permutation.size() + 1; i++) {
                List<Integer> copy = new LinkedList<>(permutation);
                copy.add(i, nums[idx]);
                res.add(copy);
            }
        }

        return res;
    }
}

