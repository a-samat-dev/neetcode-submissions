class Solution {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        recursive(map, res, new LinkedList<>());

        return res;
    }

    public void recursive(Map<Integer, Integer> nums, List<List<Integer>> res, List<Integer> currList) {
        if (nums.isEmpty()) {
            res.add(new LinkedList<>(currList));
            return;
        }

        Map<Integer, Integer> copyNums = new HashMap<>(nums);

        for (Map.Entry<Integer, Integer> entry : nums.entrySet()) {
            copyNums.put(entry.getKey(), copyNums.get(entry.getKey()) - 1);
            currList.add(entry.getKey());
            if (copyNums.get(entry.getKey()) == 0) {
                copyNums.remove(entry.getKey());
            }
            recursive(copyNums, res, currList);
            copyNums.put(entry.getKey(), copyNums.getOrDefault(entry.getKey(), 0) + 1);
            currList.remove(currList.size() - 1);
        }
    }
}

