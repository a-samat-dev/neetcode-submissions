class Solution:
    leftIdx = 0
    rightIdx = 0

    def longestPalindrome(self, s: str) -> str:
        def longestPalindromeRec(s: str, left: int, right: int):
            if left < 0 or right >= len(s): return

            if s[left] == s[right] and right - left + 1 > self.rightIdx - self.leftIdx:
                self.leftIdx = left
                self.rightIdx = right

            if s[left] == s[right]:
                longestPalindromeRec(s, left - 1, right + 1)

        for i in range(len(s)):
            longestPalindromeRec(s, i, i)
            longestPalindromeRec(s, i, i + 1)

        return s[self.leftIdx: self.rightIdx + 1]