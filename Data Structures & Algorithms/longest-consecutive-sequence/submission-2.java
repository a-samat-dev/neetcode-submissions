class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0)
            return 0;
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> counts = new HashMap<>();
        Map<Integer, List<Integer>> edges = new HashMap<>();
        Queue<int[]> queue = new LinkedList<>();

        int max = 1;

        for (int n : nums) {
            set.add(n);
        }
        for (int n : set) {
            int lessN = n - 1;
            counts.putIfAbsent(n, 0);
            counts.putIfAbsent(lessN, 0);
            edges.putIfAbsent(n, new ArrayList<>());
            edges.putIfAbsent(lessN, new ArrayList<>());

            if (set.contains(lessN)) {
                counts.put(n, counts.get(n) + 1);
                edges.get(lessN).add(n);
            }
        }
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (entry.getValue() == 0)
                queue.add(new int[] { entry.getKey(), 1 });
        }

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            max = Math.max(max, poll[1]);

            for (Integer nextN : edges.get(poll[0])) {
                counts.put(nextN, counts.get(nextN) - 1);

                if (counts.get(nextN) == 0)
                    queue.add(new int[] { nextN, poll[1] + 1 });
            }
        }

        return max;
    }
}
