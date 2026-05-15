public class WordDictionary {

    private Map<Character, WordDictionary> map;
    private boolean isWord;

    public WordDictionary() {
        this.map = new HashMap<>();
    }

    public void addWord(String word) {
        WordDictionary curr = this;

        for (char c : word.toCharArray()) {
            curr.map.putIfAbsent(c, new WordDictionary());
            curr = curr.map.get(c);
        }

        curr.isWord = true;
    }

    public boolean search(String word) {
        Queue<WordDictionary> list = new LinkedList<>();
        list.add(this);

        for (char c : word.toCharArray()) {
            Queue<WordDictionary> tempList = new LinkedList<>();

            if (c == '.') {
                for (WordDictionary wordDictionary : list) {
                    tempList.addAll(wordDictionary.map.values());
                }
            } else {
                for (WordDictionary wordDictionary : list) {
                    if (wordDictionary.map.containsKey(c)) {
                        tempList.add(wordDictionary.map.get(c));
                    }
                }
            }

            list = tempList;
        }

        return list.stream().anyMatch(s -> s.isWord);
    }
}
