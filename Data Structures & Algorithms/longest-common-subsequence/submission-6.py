class Solution:
    text1 = None
    text2 = None
    memo = None

    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        self.text1 = text1
        self.text2 = text2
        self.memo = {}
        return self.longestCommonSubsequenceRec(0, 0)

    def longestCommonSubsequenceRec(self, idx1, idx2) -> int:
        if idx1 == len(self.text1) or idx2 == len(self.text2):
            return 0
        key = str(idx1) + " - " + str(idx2)
        if key in self.memo:
            return self.memo[key]
        if self.text1[idx1] == self.text2[idx2]:
            return 1 + self.longestCommonSubsequenceRec(idx1 + 1, idx2 + 1)
        res = self.longestCommonSubsequenceRec(idx1 + 1, idx2)
        res = max(res, self.longestCommonSubsequenceRec(idx1, idx2 + 1))
        self.memo[key] = res
        return res