class UnionFind {

    private int[] arr;

    public UnionFind(int n) {
        this.arr = new int[n];

        for (int i = 0; i < this.arr.length; i++) {
            this.arr[i] = i;
        }
    }

    public int find(int x) {
        int currIdx = x;

        while (this.arr[currIdx] != currIdx) {
            currIdx = this.arr[currIdx];
        }

        return currIdx;
    }

    public boolean isSameComponent(int x, int y) {
        int xFind = this.find(x);
        int yFind = this.find(y);

        return xFind == yFind;
    }

    public boolean union(int x, int y) {
        if (this.arr[x] == this.arr[y]) {
            return false;
        }

        int xRoot = find(x);
        int yRoot = find(y);
        this.arr[yRoot] = xRoot;

        return true;
    }

    public int getNumComponents() {
        int res = 0;

        for (int i = 0; i < this.arr.length; i++) {
            if (i == this.arr[i]) {
                res++;
            }
        }

        return res;
    }
}
