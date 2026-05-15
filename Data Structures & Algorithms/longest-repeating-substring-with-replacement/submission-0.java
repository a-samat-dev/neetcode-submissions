class Solution {
    public int characterReplacement(String s, int k) {
        int res = 0;
        Map<Character, Integer> countMap = new HashMap<>();
        int l = 0;
        int maxFreq = 0;

        for (int r = 0; r < s.length(); r++) {
            char rightChar = s.charAt(r);
            countMap.put(rightChar, countMap.getOrDefault(rightChar, 0) + 1);
            maxFreq = Math.max(maxFreq, countMap.get(rightChar));

            while (r - l + 1 - maxFreq > k) {
                char leftChar = s.charAt(l);
                countMap.put(leftChar, countMap.get(leftChar) - 1);
                l++;
            }

            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}
