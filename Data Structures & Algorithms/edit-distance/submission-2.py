class Solution:
    def minDistance(self, word1: str, word2: str) -> int:
        dp = [[0 for _ in range(len(word1) + 1)] for _ in range(len(word2) + 1)]

        for i in range(len(dp[0])):
            dp[0][i] = i
        for i in range(len(dp)):
            dp[i][0] = i

        for row in range(1, len(dp)):
            word2Char = word2[row - 1]

            for col in range(1, len(dp[0])):
                word1Char = word1[col - 1]

                if word1Char == word2Char:
                    dp[row][col] = dp[row - 1][col - 1]
                    continue

                if row >= col:
                    dp[row][col] = min(min(dp[row - 1][col], dp[row - 1][col - 1]), dp[row][col - 1]) + 1
                else:
                    dp[row][col] = dp[row][col - 1] + 1

        return dp[len(dp) - 1][len(dp[0]) - 1]