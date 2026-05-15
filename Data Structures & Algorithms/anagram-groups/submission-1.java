public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Map<Character, Integer>, List<String>> map = new HashMap<>();

        for (String str : strs) {
            Map<Character, Integer> currMap = new HashMap<>();

            for (char c : str.toCharArray()) {
                currMap.put(c, currMap.getOrDefault(c, 0) + 1);
            }

            if (map.containsKey(currMap)) {
                map.get(currMap).add(str);
            } else {
                List<String> linkedLis = new LinkedList<>();
                linkedLis.add(str);
                map.put(currMap, linkedLis);
            }
        }

        return map.values().stream().toList();
    }
}
