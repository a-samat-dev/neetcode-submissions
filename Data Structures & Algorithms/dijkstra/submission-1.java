class Solution {
    public Map<Integer, Integer> shortestPath(int n, List<List<Integer>> edges, int src) {
        Map<Integer, Integer> result = new HashMap<>();
        for (int i = 0; i < n; i++)
            result.put(i, src == i ? 0 : Integer.MAX_VALUE);
        Queue<List<Integer>> queue = new PriorityQueue<>(Comparator.comparing(e -> e.get(0)));
        Set<Integer> visited = new HashSet<>();
        queue.add(List.of(0, src));
        Map<Integer, List<List<Integer>>> edgesMap = new HashMap<>();

        for (List<Integer> edge : edges) {
            edgesMap.putIfAbsent(edge.get(0), new ArrayList<>());
            edgesMap.get(edge.get(0)).add(List.of(edge.get(1), edge.get(2)));
        }

        while (!queue.isEmpty()) {
            Queue<List<Integer>> tempQueue = new PriorityQueue<>(Comparator.comparing(e -> e.get(0)));

            while (!queue.isEmpty()) {
                List<Integer> poll = queue.poll();
                if (visited.contains(poll.get(1))) continue;
                visited.add(poll.get(1));
                List<List<Integer>> currNodeEdges = edgesMap.get(poll.get(1));
                if (currNodeEdges == null || currNodeEdges.isEmpty()) continue;
                int currDistance = result.get(poll.get(1));

                for (List<Integer> edge : currNodeEdges) {
                    int newDistance = currDistance + edge.get(1);
                    if (newDistance >= result.get(edge.get(0))) continue;
                    result.put(edge.get(0), newDistance);
                    tempQueue.add(List.of(newDistance, edge.get(0)));
                }
            }

            queue = tempQueue;
        }

        for (Map.Entry<Integer, Integer> entry : result.entrySet()) {
            if (result.get(entry.getKey()) == Integer.MAX_VALUE)
                result.put(entry.getKey(), -1);
        }
        
        return result;
    }
}
