public class Solution {

    public int maximumProfit(List<Integer> profit, List<Integer> weight, int capacity) {
        int[][] dp = new int[profit.size() + 1][capacity + 1];

        for (int row = 1; row < dp.length; row++) {
            for (int col = 1; col < dp[0].length; col++) {
                if (col >= weight.get(row - 1)) {
                    int currProfit = profit.get(row - 1);
                    int capacityLeft = col - weight.get(row - 1);
                    dp[row][col] = Math.max(dp[row - 1][col], currProfit + dp[row - 1][capacityLeft]);
                } else {
                    dp[row][col] = dp[row-1][col];
                }
            }
        }

        return dp[dp.length - 1][dp[0].length - 1];
    }
}