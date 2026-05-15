class MinHeap {

    private Queue<Integer> queue;

    public MinHeap() {
        this.queue = new PriorityQueue<>();
    }

    public void push(int val) {
        this.queue.add(val);
    }

    public Integer pop() {
        if (this.queue.isEmpty()) {
            return -1;
        }
        return this.queue.poll();
    }

    public Integer top() {
        if (this.queue.isEmpty()) {
            return -1;
        }
        return this.queue.peek();
    }

    public void heapify(List<Integer> nums) {
        for (Integer num : nums) {
            this.queue.add(num);
        }
    }
}
