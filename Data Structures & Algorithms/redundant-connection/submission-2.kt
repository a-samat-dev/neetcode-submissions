class Solution {

    fun findRedundantConnection(edges: Array<IntArray>): IntArray {
        var unionFind = UnionFind()

        for (ints in edges) {
            if (!unionFind.union(ints[0], ints[1])) return ints
        }

        return intArrayOf()
    }

    private class UnionFind() {

        private val parentMap = mutableMapOf<Int, Int>()
        private val rankMap = mutableMapOf<Int, Int>()

        fun union(v1: Int, v2: Int): Boolean {
            parentMap.putIfAbsent(v1, v1)
            parentMap.putIfAbsent(v2, v2)
            rankMap.putIfAbsent(v1, 0)
            rankMap.putIfAbsent(v2, 0)
            val v1Root = find(v1)
            val v2Root = find(v2)
            if (v1Root == v2Root) return false
            val v1Rank = rankMap[v1Root]!!
            val v2Rank = rankMap[v2Root]!!

            when {
                v1Rank > v2Rank -> {
                    parentMap[v1Root] = v2Root
                }

                v2Rank < v1Rank -> {
                    parentMap[v2Root] = v1Root
                }

                else -> {
                    parentMap[v2Root] = v1Root
                    rankMap[v1Root] = 1 + rankMap[v1Root]!!
                }
            }

            return true
        }

        private fun find(v: Int): Int {
            if (parentMap[v] == v) return v
            val root = find(parentMap[v]!!)
            parentMap[v] = root
            return root
        }
    }
}
