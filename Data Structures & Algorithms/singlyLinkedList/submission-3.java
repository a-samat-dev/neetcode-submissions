class LinkedList {

    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {
    }

    public int get(int index) {
        if (index >= this.size || index < 0) {
            return -1;
        }

        Node currNode = this.head;

        while (index > 0) {
            currNode = currNode.next;
            index--;
        }

        return currNode.val;
    }

    public void insertHead(int val) {
        if (this.size == 0) {
            this.head = new Node(val);
            this.tail = this.head;
            this.size++;
            return;
        }

        this.size++;
        Node newHead = new Node(val);
        newHead.next = this.head;
        this.head = newHead;
    }

    public void insertTail(int val) {
        if (this.size == 0) {
            this.head = new Node(val);
            this.tail = this.head;
            this.size++;
            return;
        }
        
        this.size++;
        this.tail.next = new Node(val);
        this.tail = this.tail.next;
    }

    public boolean remove(int index) {
        if (index >= this.size) {
            return false;
        }

        this.size--;
        Node prevNode = null;
        Node currNode = this.head;

        for (int i = 0; i < index; i++) {
            prevNode = currNode;
            currNode = currNode.next;
        }

        if (prevNode != null) {
            prevNode.next = currNode.next;
        } else {
            this.head = this.head.next;
        }

        if (this.tail == currNode) {
            this.tail = prevNode;
        }

        return true;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Node currNode = this.head;

        while (currNode != null) {
            arrayList.add(currNode.val);
            currNode = currNode.next;
        }

        return arrayList;
    }

    private static class Node {

        public int val;
        public Node next;

        public Node(int val) {
            this.val = val;
        }
    }
}

