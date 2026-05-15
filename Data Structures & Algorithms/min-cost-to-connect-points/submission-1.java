class Solution {
    public int minCostConnectPoints(int[][] points) {
        List<List<Integer>> edges = getEdges(points); // n^2
        int res = 0;
        UnionFind uf = new UnionFind(points.length);

        for (List<Integer> edge : edges) {
            if (uf.union(edge.get(0), edge.get(1))) {
                res += edge.get(2);

                if (uf.getCurrNumOfRoots() == 1) {
                    return res;
                }
            }
        }

        return res;
    }

    private List<List<Integer>> getEdges(int[][] points) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < points.length - 1; i++) {
            int[] point1 = points[i];

            for (int j = i + 1; j < points.length; j++) {
                int[] point2 = points[j];
                int distance = Math.abs(point1[0] - point2[0]) + Math.abs(point1[1] - point2[1]);
                result.add(List.of(i, j, distance));
            }
        }

        result.sort((a, b) -> Integer.compare(a.get(2), b.get(2)));

        return result;
    }

    private static class UnionFind {

        private int[] nodes;
        private int[] rank;
        private int currNumOfRoots;

        public UnionFind(int size) {
            nodes = new int[size];
            rank = new int[size];
            currNumOfRoots = size;

            for (int i = 0; i < nodes.length; i++) {
                nodes[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int a) {
            if (nodes[a] == a) {
                return a;
            }
            int root = find(nodes[a]);
            nodes[a] = root;
            return root;
        }

        public boolean union(int a, int b) {
            int aRoot = find(a);
            int bRoot = find(b);

            if (aRoot == bRoot)
                return false;

            if (rank[aRoot] == rank[bRoot]) {
                rank[aRoot]++;
                nodes[bRoot] = aRoot;
            } else if (rank[aRoot] > rank[bRoot]) {
                nodes[bRoot] = aRoot;
            } else {
                nodes[aRoot] = bRoot;
            }
            currNumOfRoots--;

            return true;
        }

        public int getCurrNumOfRoots() {
            return currNumOfRoots;
        }
    }
}
