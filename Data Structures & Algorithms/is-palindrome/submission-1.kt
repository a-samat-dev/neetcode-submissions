class Solution {
    fun isPalindrome(s: String): Boolean {
        var str = s.filter { it.isLetterOrDigit() }
        var left = 0
        var right = str.length - 1

        while (left < right) {
            if (str[left].lowercase() != str[right].lowercase()) return false
            left++
            right--
        }

        return true
    }
}