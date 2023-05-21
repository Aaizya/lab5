public class Main {
    public static void main(String[] args) {
        BST<Integer, String> tree = new BST<>();

        // Populating the tree
        tree.put(5, "A");
        tree.put(2, "B");
        tree.put(8, "C");
        tree.put(1, "D");
        tree.put(4, "G");

        // Iterating over the tree and printing key-value pairs
        for (BST.KeyValue<Integer, String> elem : tree) {
            System.out.println("Key is " + elem.getKey() + " and Value is " + elem.getValue());
        }

        // Accessing value using key
        System.out.println("Value for key 8: " + tree.get(8));

        // Deleting a key
        tree.delete(2);

        // Iterating over the modified tree
        System.out.println("After deletion:");
        for (BST.KeyValue<Integer, String> elem : tree) {
            System.out.println("Key is " + elem.getKey() + " and Value is " + elem.getValue());
        }

        // Getting the size of the tree
        System.out.println("Size of the tree: " + tree.size());
    }
}