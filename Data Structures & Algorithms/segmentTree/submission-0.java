public class SegmentTree {

    private Node root;
    private int[] nums;

    public SegmentTree(int[] nums) {
        this.nums = nums;
        this.root = buildTree(0, nums.length - 1);
    }

    public Node buildTree(int l, int r) {
        if (l == r) {
            return new Node(null, null, l, r, nums[l]);
        }

        int mid = (r + l) / 2;
        Node leftNode = buildTree(l, mid);
        Node rightNode = buildTree(mid + 1, r);

        return new Node(leftNode, rightNode, l, r, leftNode.val + rightNode.val);
    }

    public void update(int index, int val) {
        update(this.root, index, val);
    }

    private int update(Node node, int index, int val) {
        if (node.leftIdx == index && node.rightIdx == index) {
            node.val = val;
            return node.val;
        }

        int mid = (node.leftIdx + node.rightIdx) / 2;

        if (index <= mid) {
            node.val = node.right.val + update(node.left, index, val);
        } else {
            node.val = node.left.val + update(node.right, index, val);
        }

        return node.val;
    }

    public int query(int L, int R) {
        return query(this.root, L, R);
    }

    private int query(Node node, int L, int R) {
        if (node == null) {
            return 0;
        }
        if (L == node.leftIdx && R == node.rightIdx) {
            return node.val;
        }

        int mid = (node.leftIdx + node.rightIdx) / 2;

        if (R <= mid) {
            return query(node.left, L, R);
        } else if (L > mid) {
            return query(node.right, L, R);
        } else {
            return query(node.left, L, mid) + query(node.right, mid + 1, R);
        }
    }

    private class Node {

        Node left;
        Node right;
        int leftIdx;
        int rightIdx;
        int val;

        public Node(Node left, Node right, int leftIdx, int rightIdx, int val) {
            this.left = left;
            this.right = right;
            this.leftIdx = leftIdx;
            this.rightIdx = rightIdx;
            this.val = val;
        }
    }
}
