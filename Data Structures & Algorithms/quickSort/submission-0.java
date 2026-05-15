
public class Solution {

    public List<Pair> quickSort(List<Pair> pairs) {
        quickSort(pairs, 0, pairs.size() - 1);
        return pairs;
    }

    private void quickSort(List<Pair> pairs, int start, int end) {
        if (end - start + 1 <= 1) {
            return;
        }

        int pivotIdx = start;
        int currIdx = start;

        while (currIdx < end) {
            if (pairs.get(currIdx).key < pairs.get(end).key) {
                swap(pairs, currIdx, pivotIdx);
                pivotIdx++;
            }

            currIdx++;
        }

        swap(pairs, pivotIdx, end);
        quickSort(pairs, start, pivotIdx - 1);
        quickSort(pairs, pivotIdx + 1, end);
    }

    private void swap(List<Pair> pairs, int i, int j) {
        Pair temp = pairs.get(i);
        pairs.set(i, pairs.get(j));
        pairs.set(j, temp);
    }
}