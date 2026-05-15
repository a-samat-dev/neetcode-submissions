public class Solution {

    public List<Pair> mergeSort(List<Pair> pairs) {
        if (pairs.size() < 2) {
            return pairs;
        }
        int mid = pairs.size() / 2;
        List<Pair> list1 = mergeSort(pairs.subList(0, mid));
        List<Pair> list2 = mergeSort(pairs.subList(mid, pairs.size()));

        return merge(list1, list2);
    }

    public List<Pair> merge(List<Pair> list1, List<Pair> list2) {
        List<Pair> mergedList = new ArrayList<>(list1.size() + list2.size());
        int idx1 = 0;
        int idx2 = 0;

        while (true) {
            if (idx1 == list1.size() && idx2 == list2.size()) {
                break;
            }
            if (idx1 == list1.size()) {
                while (idx2 < list2.size()) {
                    mergedList.add(list2.get(idx2));
                    idx2++;
                }
                break;
            }
            if (idx2 == list2.size()) {
                while (idx1 < list1.size()) {
                    mergedList.add(list1.get(idx1));
                    idx1++;
                }
                break;
            }
            if (list1.get(idx1).key <= list2.get(idx2).key) {
                mergedList.add(list1.get(idx1));
                idx1++;
            } else {
                mergedList.add(list2.get(idx2));
                idx2++;
            }
        }

        return mergedList;
    }
}