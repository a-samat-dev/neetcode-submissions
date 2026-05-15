class Solution {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();

        if (nums.length == 0) {
            return res;
        }

        List<Integer> firstLis = new LinkedList<>();
        firstLis.add(nums[0]);
        res.add(firstLis);

        for (int i = 1; i < nums.length; i++) {
            List<List<Integer>> tempRes = new LinkedList<>();

            for (List<Integer> currList : res) {
                for (int j = 0; j < currList.size() + 1; j++) {
                    List<Integer> copyCurrList = new LinkedList<>(currList);
                    copyCurrList.add(j, nums[i]);
                    tempRes.add(copyCurrList);
                }
            }

            res = tempRes;
        }

        return res;
    }
}

