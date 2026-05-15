public class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()));
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            priorityQueue.add(entry);
        }

        for (int i = 0; i < k; i++) {
            res[i] = Objects.requireNonNull(priorityQueue.poll()).getKey();
        }

        return res;
    }
}
