class Solution {
    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }
        return uf.getNumOfRoots();
    }

    private static class UnionFind {

        private int[] nodes;
        private int[] rank;
        private int size;

        public UnionFind(int size) {
            this.size = size;
            this.nodes = new int[size];
            this.rank = new int[size];

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

        public void union(int a, int b) {
            int aRoot = find(a);
            int bRoot = find(b);

            if (rank[aRoot] == rank[bRoot]) {
                rank[aRoot]++;
                nodes[bRoot] = aRoot;
            } else if (rank[aRoot] > rank[bRoot]) {
                nodes[bRoot] = aRoot;
            } else {
                nodes[aRoot] = bRoot;
            }
        }

        public int getNumOfRoots() {
            int size = 0;

            for (int i = 0; i < nodes.length; i++) {
                if (nodes[i] == i)
                    size++;
            }

            return size;
        }
    }
}
