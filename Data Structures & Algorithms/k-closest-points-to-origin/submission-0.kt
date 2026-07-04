class Solution {
    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
        var heap = PriorityQueue<IntArray> { a, b ->
            var x = a[0].times(a[0]).plus(a[1].times(a[1]))
            var y = b[0].times(b[0]).plus(b[1].times(b[1]))
            sqrt(y.toDouble()).compareTo(sqrt(x.toDouble()))
        }

        for (point in points) {
            heap.add(point)

            if (heap.size > k)
                heap.poll()
        }

        var res = mutableListOf<IntArray>()
        var currK = k

        while (currK > 0) {
            res.add(heap.poll())
            currK--
        }

        return res.toTypedArray()
    }
}