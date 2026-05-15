public class PrefixTree {

    private Map<Character, PrefixTree> map = new HashMap<>();
    private boolean isWord;

    public PrefixTree() {
    }

    public void insert(String word) {
        PrefixTree curr = this;

        for (char c : word.toCharArray()) {
            curr.map.putIfAbsent(c, new PrefixTree());
            curr = curr.map.get(c);
        }

        curr.isWord = true;
    }

    public boolean search(String word) {
        PrefixTree curr = this;

        for (char c : word.toCharArray()) {
            if (!curr.map.containsKey(c)) {
                return false;
            }
            curr = curr.map.get(c);
        }

        return curr.isWord;
    }
    public boolean startsWith(String prefix) {
        PrefixTree curr = this;

        for (char c : prefix.toCharArray()) {
            if (!curr.map.containsKey(c)) {
                return false;
            }
            curr = curr.map.get(c);
        }

        return true;
    }
}
