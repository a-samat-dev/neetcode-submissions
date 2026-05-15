class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> charMap = Map.of(')', '(', '}', '{', ']', '[');

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.add(c);
                continue;
            }

            if (stack.isEmpty() || !charMap.get(c).equals(stack.pop())) {
                return false;
            }
        }

        return stack.isEmpty();
    }
}

