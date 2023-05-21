# Binary Search Tree
This code implements a binary search tree (BST). It includes methods for putting key-value pairs, getting a value by key, deleting a key, and iterating over the tree using an in-order traversal. The BSTIterator class provides an iterator that allows you to access both the key and value during the iteration. The main method demonstrates the usage of the BST by populating it and iterating over its elements, accessing values using keys, deleting a key, and retrieving the size of the tree.

 # Introduction
The Binary Search Tree (BST) is a data structure that provides an efficient way to store key-value pairs. It is a binary tree where each node has at most two children, and the left child is always smaller than the parent, while the right child is always larger. This property enables efficient searching, insertion, and deletion operations.
# Features

 ### Insertion:  
Add key-value pairs to the tree.

### Search: 
Retrieve the value associated with a given key.

### Deletion:
Remove key-value pairs from the tree.

### In-order Traversal: 
Traverse the tree in ascending order of keys.

### Size: 
Get the number of elements in the tree.

# Methods
put(K key, V value): Inserts a key-value pair into the BST.

get(K key): Retrieves the value associated with the given key.

delete(K key): Deletes the key-value pair with the given key from the BST.

size(): Returns the number of elements in the BST.

iterator(): Returns an iterator over the key-value pairs in the BST.
