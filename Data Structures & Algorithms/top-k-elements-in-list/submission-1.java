public class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer>[] freq = new LinkedList[nums.length];

        for (int i = 0; i < freq.length; i++) {
            freq[i] = new LinkedList<>();
        }

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            freq[entry.getValue() - 1].add(entry.getKey());
        }

        int currK = 0;

        for (int i = freq.length - 1; i >= 0; i--) {
            for (Integer integer : freq[i]) {
                res[currK] = integer;
                currK++;

                if (currK == k) {
                    return res;
                }
            }
        }

        return res;
    }
}
