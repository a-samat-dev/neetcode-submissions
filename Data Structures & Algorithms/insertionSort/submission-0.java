public class Solution {

    public List<List<Pair>> insertionSort(List<Pair> pairs) {
        List<List<Pair>> result = new LinkedList<>();

        for (int i = 0; i < pairs.size(); i++) {
            int j = i;

            while (j - 1 >= 0 && pairs.get(j).key < pairs.get(j - 1).key) {
                swap(pairs, j - 1, j);
                j--;
            }

            result.add(new LinkedList<>(pairs));
        }

        return result;
    }

    private void swap(List<Pair> pairs, int idx1, int idx2) {
        Pair temp = pairs.get(idx1);
        pairs.set(idx1, pairs.get(idx2));
        pairs.set(idx2, temp);
    }

}