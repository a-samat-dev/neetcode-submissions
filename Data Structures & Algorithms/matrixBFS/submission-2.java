public class Solution {

    public int shortestPath(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        if (grid[0][0] == 0) {
            queue.add(new int[]{0, 0, 0});
        }
        int res = Integer.MAX_VALUE;
        Set<String> visited = new HashSet<>();

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int row = poll[0];
            int col = poll[1];
            int pathCount = poll[2];

            if (row == grid.length - 1 && col == grid[0].length - 1) {
                res = Math.min(res, pathCount);
                continue;
            }

            if (visited.contains(row + ":" + col) || !isInRange(grid, row, col) || grid[row][col] == 1) {
                continue;
            }

            visited.add(row + ":" + col);
            queue.add(new int[]{row, col + 1, pathCount + 1});
            queue.add(new int[]{row + 1, col, pathCount + 1});
            queue.add(new int[]{row, col - 1, pathCount + 1});
            queue.add(new int[]{row - 1, col, pathCount + 1});
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private boolean isInRange(int[][] grid, int row, int col) {
        return row >= 0 && col >= 0 && row < grid.length && col < grid[0].length;
    }
}