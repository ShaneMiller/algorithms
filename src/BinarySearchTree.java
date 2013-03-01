/**
 * Chapter 12 Binary Search Trees - Introduction to Algorithms 2nd Edition.
 *
 * The dynamic-set operations SEARCH, MINIMUM, MAXIMUM, SUCCESSOR, PREDECESSOR, INSERT, and DELETE can be made to run in O(h) time on a binary search tree of height h.
 *
 * @param <T> The BinarySearchTree.Node key is of type T
 */
public class BinarySearchTree<T extends Comparable<T>> {

    private Node<T> root;

    public Node<T> getRoot() {
        return root;
    }

    public BinarySearchTree() {}

    public BinarySearchTree(T rootKey) {
        this.root = new Node<T>(rootKey);
    }

    public void insert(T key) {
        Node<T> node = new Node<T>(key);
        Node<T> pointerY = null;
        Node<T> pointerX = this.root;

        while(pointerX != null) {
            pointerY = pointerX;
            if(node.key.compareTo(pointerX.key) < 0) {
                pointerX = pointerX.left;
            } else {
                pointerX = pointerX.right;
            }
        }

        node.parent = pointerY;
        if(pointerY == null) {
            this.root = node; //Tree was empty
        } else if(node.key.compareTo(pointerY.key) < 0) {
            pointerY.left = node;
        } else {
            pointerY.right = node;
        }
    }

    public Node<T> delete(Node<T> node) {
        Node<T> x = null;
        Node<T> y = null;
        if(node.left == null || node.right == null) {
            y = node;
        } else {
            y = successor(node);
        }
        if(y.left != null) {
            x = y.left;
        } else {
            x = y.right;
        }
        if(x != null) {
            x.parent = y.parent;
        }
        if(y.parent == null) {
            this.root = x;
        } else if(y == y.parent.left) {
            y.parent.left = x;
        } else {
            y.parent.right = x;
        }
        if(y != node) {
            node.key = y.key;
        }
        return y;
    }


    public void inOrderWalk() {
        inOrderWalk(root);
    }

    /**
     * Walk a binary search tree to print its values in sorted order
     */
    public void inOrderWalk(Node node) {
        if(node != null) {
            inOrderWalk(node.left);
            System.out.println(node.key.toString());
            inOrderWalk(node.right);
        }
    }

    public Node<T> recursiveSearch(T key) {
        return recursiveSearch(this.root, key);
    }

    public Node<T> iterativeSearch(T key) {
        return iterativeSearch(this.root, key);
    }

    /**
     * Recursive tree-search algorithm.
     */
    public Node<T> recursiveSearch(Node<T> node, T key) {
        if(node == null || key == node.key) {
            return node;
        } else if(key.compareTo(node.key) < 0) {
            return recursiveSearch(node.left, key);
        } else {
            return recursiveSearch(node.right, key);
        }
    }


    /**
     * Iterative tree-search algorithm -- usually faster than the recursive version.
     */
    public Node<T> iterativeSearch(Node<T> node, T key) {
        while(node != null && key != node.key) {
            if(key.compareTo(node.key) < 0) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return node;
    }

    public Node<T> minimum(Node<T> node) {
        while(node.left != null) {
            node = node.left;
        }
        return node;
    }

    public Node<T> maximum(Node<T> node) {
        while(node.right != null) {
            node = node.right;
        }
        return node;
    }

    public Node<T> successor(Node<T> node) {
        if(node.right != null) {
            return minimum(node.right);
        }
        Node<T> successor = node.parent;
        while(successor != null && node == successor.right) {
            node = successor;
            successor = successor.parent;
        }
        return successor;
    }

    public Node<T> predecessor(Node<T> node) {
        if(node.left != null) {
            return maximum(node.left);
        }
        Node<T> predecessor = node.parent;
        while(predecessor != null && node == predecessor.left) {
            node = predecessor;
            predecessor = predecessor.parent;
        }
        return predecessor;
    }

    public static class Node<T> {
        private T key;
        private Node<T> left;
        private Node<T> right;
        private Node<T> parent;

        private Node(T key) {
            this.key = key;
        }

        @Override
        public String toString() {
            return key.toString();
        }
    }
}