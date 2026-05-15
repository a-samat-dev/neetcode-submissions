public class Solution {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new LinkedList<>();
        combine(n, k, 1, res, new LinkedList<>());

        return res;
    }

    private void combine(int n, int k, int currNum, List<List<Integer>> res, List<Integer> currList) {
        if (currList.size() == k) {
            res.add(new LinkedList<>(currList));
            return;
        }
        if (currNum > n) {
            return;
        }

        currList.add(currNum);
        combine(n, k, currNum + 1, res, currList);
        currList.remove(currList.size() - 1);
        combine(n, k, currNum + 1, res, currList);
    }
}
