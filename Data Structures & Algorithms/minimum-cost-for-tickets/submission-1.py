class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        daysMap = {
            0: 1,
            1: 7,
            2: 30
        }
        memo = {}

        def mincostTicketsRec(idx) -> int:
            if idx >= len(days): return 0
            if idx in memo: return memo[idx]
            res = math.inf

            for index, value in enumerate(costs):
                nextIdx = idx
                ticketExpiredDay = days[idx] + daysMap[index] - 1

                while nextIdx < len(days) and ticketExpiredDay >= days[nextIdx]:
                    nextIdx += 1

                res = min(res, mincostTicketsRec(nextIdx) + value)
            memo[idx] = res

            return res

        return mincostTicketsRec(0)