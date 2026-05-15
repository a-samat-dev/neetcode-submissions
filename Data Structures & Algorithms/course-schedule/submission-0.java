
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Integer> counts = new HashMap<>();
        Map<Integer, List<Integer>> edges = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        for (int i = 0; i < numCourses; i++) {
            counts.put(i, 0);
            edges.put(i, new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            counts.put(prerequisite[0], counts.get(prerequisite[0]) + 1);
            edges.get(prerequisite[1]).add(prerequisite[0]);
        }
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {

            if (entry.getValue() == 0) {
                queue.add(entry.getKey());
            }
        }

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            if (visited.contains(poll))
                return false;
            visited.add(poll);

            for (Integer n : edges.get(poll)) {
                counts.put(n, counts.get(n) - 1);

                if (counts.get(n) == 0) {
                    queue.add(n);
                }
            }
        }

        return visited.size() == numCourses;
    }
}