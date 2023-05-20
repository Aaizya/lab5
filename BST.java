public class BST <K extends Comparable <K>, V> {
    private Node root;
    private int size;

    private class Node {
        private K key;
        private V val;
        private Node left, right;
        private int count;


        public Node(K key, V val) {
            this.key = key;
            this.val = val;
            this.count = 1;
        }
    }

    public void put(K key, V val) {
        root = put( root , key, val);
    }
    private Node put (Node node, K key, V val) {
        if ( node == null) {
            size++;
            return new Node(key,val);
        }
        int cmp = key.compareTo (node.key);
        if (cmp<0) {
            node.left = put(node.left, key, val);
        }
        else if (cmp>0) {
            node.right= put(node.right,key,val);
        } else {
            node.val = val;
        }
        node.count = 1 + size(node.left) + size(node.right);
        return node;
    }
    public V get(K key) {
    }

    public void delete(K key) {
    }

    public Iterable<K> iterator() {}
}
