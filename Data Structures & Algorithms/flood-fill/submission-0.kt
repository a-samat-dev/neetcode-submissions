class Solution {
    fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, color: Int): Array<IntArray> {
        val visitedCells = mutableSetOf<String>()
        dfs(image, sr, sc, color, image[sr][sc], visitedCells)

        return image
    }

    private fun dfs(
        image: Array<IntArray>,
        sr: Int,
        sc: Int,
        color: Int,
        originalColor: Int,
        visitedCells: MutableSet<String>
    ) {
        if (sc < 0 || sr < 0 || sc >= image[0].size || sr >= image.size || visitedCells.contains("$sr - $sc")) return
        visitedCells.add("$sr - $sc")
        if (image[sr][sc] == originalColor) {
            image[sr][sc] = color
            dfs(image, sr, sc + 1, color, originalColor, visitedCells)
            dfs(image, sr + 1, sc, color, originalColor, visitedCells)
            dfs(image, sr, sc - 1, color, originalColor, visitedCells)
            dfs(image, sr - 1, sc, color, originalColor, visitedCells)
        }
    }
}