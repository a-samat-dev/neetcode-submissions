class HashTable {

    private Map<Integer, Integer> map;
    private int capacity;

    public HashTable(int capacity) {
        this.map = new HashMap<>(capacity);
        this.capacity = capacity;
    }

    public void insert(int key, int value) {
        if (this.map.containsKey(key)) {
            this.map.remove(key);
        }

        this.map.put(key, value);

        if (Double.parseDouble(String.valueOf(this.capacity)) / Double.parseDouble(String.valueOf(this.map.size())) <= 2) {
            resize();
        }
    }

    public int get(int key) {
        return this.map.getOrDefault(key, -1);
    }

    public boolean remove(int key) {
        if (this.map.containsKey(key)) {
            this.map.remove(key);
            return true;
        }
        return false;
    }

    public int getSize() {
        return this.map.size();
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void resize() {
        this.capacity = this.capacity * 2;
        Map<Integer, Integer> newMap = new HashMap<>(this.capacity);
        newMap.putAll(this.map);
        this.map = newMap;
    }
}

