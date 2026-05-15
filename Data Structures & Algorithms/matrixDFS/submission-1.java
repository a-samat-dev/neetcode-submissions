public class Solution {

    public int countPaths(int[][] grid) {
        Set<String> visited = new HashSet<>();
        return countPaths(grid, visited, 0, 0);
    }

    public int countPaths(int[][] grid, Set<String> visited, int row, int col) {
        if (visited.contains(row + ":" + col) || !isInRange(grid, row, col) || grid[row][col] == 1) {
            return 0;
        }
        if (row == grid.length - 1 && col == grid[0].length - 1) {
            return 1;
        }
        int res = 0;
        String key = row + ":" + col;
        visited.add(key);
        res += countPaths(grid, visited, row, col + 1);
        res += countPaths(grid, visited, row + 1, col);
        res += countPaths(grid, visited, row, col - 1);
        res += countPaths(grid, visited, row - 1, col);
        visited.remove(key);

        return res;
    }

    private boolean isInRange(int[][] arr, int row, int col) {
        return row >= 0 && col >= 0 && row < arr.length && col < arr[0].length;
    }
}