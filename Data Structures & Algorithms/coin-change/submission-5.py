class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        memo = {}

        def coinChangeRec(coins: List[int], amount: int) -> int:
            if amount < 0: return -1
            if amount == 0: return 0
            key = str(amount)
            if key in memo: return memo[key]
            res = math.inf

            for coin in coins:
                currRes = coinChangeRec(coins, amount - coin)
                if currRes == -1: continue
                res = min(res, currRes + 1)

            memo[key] = res

            return res

        finalRes = coinChangeRec(coins, amount)

        return -1 if finalRes == math.inf else finalRes