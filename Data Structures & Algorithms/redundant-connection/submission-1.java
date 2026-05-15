class Solution {

    public int[] findRedundantConnection(int[][] edges) {
        int[] nodes = new int[edges.length + 1];

        for (int i = 1; i < nodes.length; i++) {
            nodes[i] = i;
        }

        for (int[] edge : edges) {
            int n1Root = nodes[edge[0]];
            int n2Root = nodes[edge[1]];

            if (n1Root == n2Root) {
                return edge;
            }

            union(nodes, n1Root, n2Root);
        }

        return null;
    }

    private void union(int[] nodes, int n1, int n2) {
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i] == n1) {
                nodes[i] = n2;
            }
        }
    }
}
