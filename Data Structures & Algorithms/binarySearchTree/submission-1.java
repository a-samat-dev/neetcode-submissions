class TreeMap {

    private java.util.TreeMap<Integer, Integer> treeMap;

    public TreeMap() {
        this.treeMap = new java.util.TreeMap<>();
    }

    public void insert(int key, int val) {
        this.treeMap.put(key, val);
    }

    public int get(int key) {
        return this.treeMap.getOrDefault(key, -1);
    }

    public int getMin() {
        if (this.treeMap.isEmpty()) {
            return -1;
        }

        return this.treeMap.firstEntry().getValue();
    }

    public int getMax() {
        if (this.treeMap.isEmpty()) {
            return -1;
        }
        
        return this.treeMap.lastEntry().getValue();
    }

    public void remove(int key) {
        this.treeMap.remove(key);
    }

    public List<Integer> getInorderKeys() {
        List<Integer> res = new ArrayList<>(this.treeMap.size());

        for (Map.Entry<Integer, Integer> entry : this.treeMap.entrySet()) {
            res.add(entry.getKey());
        }

        return res;
    }
}
