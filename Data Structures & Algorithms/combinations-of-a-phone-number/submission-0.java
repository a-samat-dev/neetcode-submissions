class Solution {

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return List.of();
        }
        Map<Character, String> map = Map.of(
                '2', "abc",
                '3', "def",
                '4', "ghi",
                '5', "jkl",
                '6', "mno",
                '7', "pqrs",
                '8', "tuv",
                '9', "wxyz"
        );
        List<String> res = new ArrayList<>();
        letterCombinations(digits, res, 0, "", map);

        return res;
    }

    private void letterCombinations(String digits, List<String> result, int idx, String currStr, Map<Character, String> map) {
        if (idx == digits.length()) {
            result.add(currStr);
            return;
        }
        if (map.containsKey(digits.charAt(idx))) {
            String letters = map.get(digits.charAt(idx));

            for (char c : letters.toCharArray()) {
                letterCombinations(digits, result, idx + 1, currStr + c, map);
            }
        }
    }
}
