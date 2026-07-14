class Solution {
    fun countComponents(n: Int, edges: Array<IntArray>): Int {
        var unionFind = UnionFind(n)

        for (edge in edges) {
            unionFind.union(edge[0], edge[1])
        }

        return unionFind.getUniqueCount()
    }

    private class UnionFind(n: Int) {

        private val arr = IntArray(n)
        private val rank = IntArray(n)

        init {
            for (i in 0 until n) {
                arr[i] = i
            }
        }

        fun getUniqueCount(): Int {
            return arr.distinct().size
        }

        fun union(v1: Int, v2: Int) {
            val v1Root = find(v1)
            val v2Root = find(v2)
            var v1Rank = rank[v1]
            var v2Rank = rank[v2]

            when {
                v1Rank < v2Rank -> {
                    for (i in 0 until arr.size) {
                        if (arr[i] == v1Root)
                            arr[i] = v2Root
                    }
                }

                else -> {
                    rank[v1Root] += 1
                    for (i in 0 until arr.size) {
                        if (arr[i] == v2Root)
                            arr[i] = v1Root
                    }
                }
            }

            for (i in 0 until arr.size) {
                if (arr[i] == v2Root)
                    arr[i] = v1Root
            }
        }

        private fun find(v: Int): Int {
            if (arr[v] == v) return v
            var root = find(arr[v])
            arr[v] = root
            return root
        }
    }
}