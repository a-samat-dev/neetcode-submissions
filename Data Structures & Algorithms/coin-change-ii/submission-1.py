class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        memo = {}

        def changeRec(idx, currAmount: int) -> int:
            if currAmount == amount: return 1
            if currAmount > amount: return 0
            key = str(idx) + "-" + str(currAmount)
            if key in memo: return memo[key]
            res = 0

            for i in range(idx, len(coins)):
                res += changeRec(i, currAmount + coins[i])

            memo[key] = res

            return res

        return changeRec(0, 0)