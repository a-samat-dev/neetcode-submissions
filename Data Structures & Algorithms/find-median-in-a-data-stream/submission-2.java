public class MedianFinder {

    private Queue<Integer> minHeap;
    private Queue<Integer> maxHeap;

    public MedianFinder() {
        this.minHeap = new PriorityQueue<>();
        this.maxHeap = new PriorityQueue<>((n1, n2) -> Integer.compare(n2, n1));
    }

    public void addNum(int num) {
        int maxHeapValue = this.maxHeap.isEmpty() ? 0 : this.maxHeap.peek();

        if (num > maxHeapValue) {
            this.minHeap.add(num);

            if (this.minHeap.size() - this.maxHeap.size() > 1) {
                this.maxHeap.add(this.minHeap.remove());
            }
        } else {
            this.maxHeap.add(num);

            if (this.maxHeap.size() - this.minHeap.size() > 1) {
                this.minHeap.add(this.maxHeap.remove());
            }
        }
    }

    public double findMedian() {
        if (minHeap.isEmpty()) {
            return 0;
        }
        double d1 = (double) minHeap.peek();

        if ((this.minHeap.size() + this.maxHeap.size()) % 2 != 0) {
            if (this.minHeap.size() > this.maxHeap.size()) {
                return this.minHeap.peek();
            } else {
                return this.maxHeap.peek();
            }
        }

        double d2 = (double) maxHeap.peek();

        return (d1 + d2) / 2;
    }
}
