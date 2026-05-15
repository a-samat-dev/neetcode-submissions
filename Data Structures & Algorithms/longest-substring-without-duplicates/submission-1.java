public class Solution {

    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;
        int res = Integer.MIN_VALUE;

        while (right < s.length()) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            right++;
            res = Math.max(res, right - left);
        }

        return res == Integer.MIN_VALUE ? 0 : res;
    }
}
