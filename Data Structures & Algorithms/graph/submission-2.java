class Graph {

    private Map<Integer, Set<Integer>> map;

    public Graph() {
        this.map = new HashMap<>();
    }

    public void addEdge(int src, int dst) {
        this.map.putIfAbsent(src, new HashSet<>());
        this.map.get(src).add(dst);
    }

    public boolean removeEdge(int src, int dst) {
        if (this.map.containsKey(src) && this.map.get(src).contains(dst)) {
            this.map.get(src).remove(dst);
            return true;
        }

        return false;
    }

    public boolean hasPath(int src, int dst) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        Set<Integer> visited = new HashSet<>();

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            visited.add(poll);
            Set<Integer> connections = this.map.getOrDefault(poll, new HashSet<>());

            for (Integer connection : connections) {
                if (visited.contains(connection)) continue;
                if (connection == dst) return true;
                queue.add(connection);
            }
        }

        return false;
    }
}
