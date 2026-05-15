class DynamicArray {

    private int[] arr;
    private int size;

    public DynamicArray(int capacity) {
        this.arr = new int[capacity];
        this.size = 0;
    }

    public int get(int i) {
        return this.arr[i];
    }

    public void set(int i, int n) {
        this.arr[i] = n;
    }

    public void pushback(int n) {
        if (this.size == this.arr.length) {
            this.resize();
        }

        this.arr[size] = n;
        this.size++;
    }

    public int popback() {
        size--;
        int res = this.arr[size];
        this.arr[size] = 0;

        return res;
    }

    private void resize() {
        int[] tempArr = this.arr;
        this.arr = new int[size * 2];

        for (int i = 0; i < tempArr.length; i++) {
            this.arr[i] = tempArr[i];
        }
    }

    public int getSize() {
        return this.size;
    }

    public int getCapacity() {
        return this.arr.length;
    }
}
