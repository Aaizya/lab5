import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class BST<K extends Comparable<K>, V> implements Iterable<BST.KeyValue<K, V>> {
    private Node root; // Root node of the binary search tree
    private int size; // Number of elements in the tree

    private class Node {
        private K key;
        private V val;
        private Node left, right;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    /**
     * Inserts a key-value pair into the binary search tree.
     *
     *  key The key of the element
     *  val The value associated with the key
     */
    public void put(K key, V val) {
        root = put(root, key, val);
    }

    private Node put(Node node, K key, V val) {
        if (node == null) {
            size++;
            return new Node(key, val);
        }

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = put(node.left, key, val);
        } else if (cmp > 0) {
            node.right = put(node.right, key, val);
        } else {
            node.val = val;
        }

        return node;
    }

    /**
     * Retrieves the value associated with a given key from the binary search tree.
     *
     *  key The key of the element to retrieve
     * return The value associated with the key, or null if the key is not found
     */
    public V get(K key) {
        Node node = get(root, key);
        return node != null ? node.val : null;
    }

    private Node get(Node node, K key) {
        if (node == null) {
            return null;
        }

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return get(node.left, key);
        } else if (cmp > 0) {
            return get(node.right, key);
        } else {
            return node;
        }
    }

    /**
     * Deletes a key-value pair from the binary search tree.
     *
     */
    public void delete(K key) {
        root = delete(root, key);
    }

    private Node delete(Node node, K key) {
        if (node == null) {
            return null;
        }

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = delete(node.left, key);
        } else if (cmp > 0) {
            node.right = delete(node.right, key);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
                Node successor = findMin(node.right);
                node.key = successor.key;
                node.val = successor.val;
                node.right = delete(node.right, successor.key);
            }
        }

        return node;
    }

    private Node findMin(Node node) {
        if (node.left == null) {
            return node;
        }
        return findMin(node.left);
    }

    /**
     * Returns the number of elements in the binary search tree.
     *
     * return The size of the tree
     */
    public int size() {
        return size;
    }

    /**
     * Returns an iterator over the elements of the binary search tree in ascending order of keys.
     *
     * return An iterator over the key-value pairs in the tree
     */
    public Iterator<KeyValue<K, V>> iterator() {
        return new BSTIterator();
    }

    /**
     * Represents a key-value pair in the binary search tree.
     *
     */
    public static class KeyValue<K, V> {
        private K key;
        private V value;

        public KeyValue(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    private class BSTIterator implements Iterator<KeyValue<K, V>> {
        private Node current;
        private Stack<Node> stack;

        public BSTIterator() {
            stack = new Stack<>();
            current = root;
        }

        public boolean hasNext() {
            return !stack.isEmpty() || current != null;
        }

        public KeyValue<K, V> next() {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            if (stack.isEmpty()) {
                throw new NoSuchElementException("No more elements to iterate.");
            }

            Node node = stack.pop();
            current = node.right;

            return new KeyValue<>(node.key, node.val);
        }
    }

}

