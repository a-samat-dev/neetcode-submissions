class Deque {

    private Node head;
    private Node tail;

    public Deque() {

    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public void append(int value) {
        if (this.tail == null) {
            this.head = new Node(value);
            this.tail = this.head;
        } else {
            this.tail.next = new Node(value);
            this.tail.next.prev = this.tail;
            this.tail = this.tail.next;
        }
    }

    public void appendleft(int value) {
        if (this.head == null) {
            this.head = new Node(value);
            this.tail = this.head;
        } else {
            this.head.prev = new Node(value);
            this.head.prev.next = this.head;
            this.head = this.head.prev;
        }
    }

    public int pop() {
        if (this.tail == null) {
            return  -1;
        }

        Node tempNode = this.tail;

        if (tempNode == this.head) {
            this.head = null;
            this.tail = null;
        } else {
            this.tail.prev.next = null;
            this.tail = tempNode.prev;
        }

        return tempNode.val;
    }

    public int popleft() {
        if (this.head == null) {
            return  -1;
        }

        Node tempNode = this.head;

        if (tempNode == this.tail) {
            this.head = null;
            this.tail = null;
        } else {
            this.head.next.prev = null;
            this.head = tempNode.next;
        }

        return tempNode.val;
    }

    private static class Node {

        int val;
        Node prev;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }
}
