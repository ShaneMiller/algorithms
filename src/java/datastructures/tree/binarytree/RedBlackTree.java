package datastructures.tree.binarytree;

import org.apache.log4j.Logger;

import java.util.Collection;

/**
 * Chapter 12 Binary Search Trees - Introduction to Algorithms 2nd Edition.
 *
 * The dynamic-set operations SEARCH, MINIMUM, MAXIMUM, SUCCESSOR, PREDECESSOR, INSERT, and DELETE can be made to run in O(h) time on a binary search tree of height h.
 *
 * @param <T> The BinarySearchTree.Node key is of type T
 */
public class RedBlackTree<T extends Comparable<T>> {
    public Logger log = Logger.getLogger(BinarySearchTree.class);
    private Node<T> root;
    private final Node<T> sentinal;

    public RedBlackTree() {
        this.sentinal = new Node<T>();
        this.sentinal.color = Node.Color.BLACK;
        this.sentinal.parent = this.sentinal;

        this.root = sentinal;
    }

    public RedBlackTree(Collection<T> keys) {
        this();
        for(T key : keys) {
            insert(key);
        }
    }

    public T getRoot() {
        return (root == null) ? null : root.key;
    }

    private void leftRotate(Node<T> node) {
        Node<T> y = node.right;
        node.right = y.left;
        if(y.left != sentinal) {
            y.left.parent = node;
        }
        y.parent = node.parent;
        if(node.parent == sentinal) {
            this.root = y;
        } else if(node == node.parent.left) {
            node.parent.left = y;
        } else {
            node.parent.right = y;
        }
        y.left = node;
        node.parent = y;
    }

    private void rightRotate(Node<T> node) {
        Node<T> y = node.left;
        node.left = y.right;
        if(y.right != sentinal) {
            y.right.parent = node;
        }
        y.parent = node.parent;
        if(node.parent == sentinal) {
            this.root = y;
        } else if(node == node.parent.right) {
            node.parent.right = y;
        } else {
            node.parent.left = y;
        }
        y.right = node;
        node.parent = y;
    }

    public void insert(T key) {
        insert(new Node<T>(key, sentinal, sentinal, sentinal, Node.Color.BLACK));
    }

    private void insert(Node<T> node) {
        Node<T> y = sentinal;
        Node<T> x = this.root;

        while(x != sentinal) {
            y = x;
            if(node.key.compareTo(x.key) < 0) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        node.parent = y;
        if(y == sentinal) {
            this.root = node;
        } else if(node.key.compareTo(y.key) < 0) {
            y.left = node;
        } else {
            y.right = node;
        }
        node.left = sentinal;
        node.right = sentinal;
        node.color = Node.Color.RED;
        insertFixup(node);
    }

    private void insertFixup(Node<T> node) {
        while(node.parent.color == Node.Color.RED) {
            if(node.parent == node.parent.parent.left) {
                Node<T> uncle = node.parent.parent.right;
                if(uncle.color == Node.Color.RED) {
                    node.parent.color = Node.Color.BLACK; //father
                    uncle.color = Node.Color.BLACK; //uncle
                    node.parent.parent.color = Node.Color.RED; //grandfather
                    node = node.parent.parent;
                } else {
                    if(node == node.parent.right) {
                        node = node.parent;
                        leftRotate(node);
                    }

                    node.parent.color = Node.Color.BLACK;
                    node.parent.parent.color = Node.Color.RED;
                    rightRotate(node.parent.parent);
                }
            } else {
                Node<T> uncle = node.parent.parent.right;
                if(uncle.color == Node.Color.RED) {
                    node.parent.color = Node.Color.BLACK;
                    uncle.color = Node.Color.BLACK;
                    node.parent.parent.color = Node.Color.RED;
                    node = node.parent.parent;
                } else {
                    if(node == node.parent.right) {
                        node = node.parent;
                        rightRotate(node);
                    }

                    node.parent.color = Node.Color.BLACK;
                    node.parent.parent.color = Node.Color.RED;
                    leftRotate(node.parent.parent);       //i==5
                }
            }

        }
        root.color = Node.Color.BLACK;
    }

    public void inOrderWalk() {
        inOrderWalk(this.root);
    }

    private void inOrderWalk(Node node) {
        if(node != sentinal) {
            inOrderWalk(node.left);
            log.info(node.key);
            inOrderWalk(node.right);
        }
    }

    private static class Node<T> {
        private enum Color {
            RED, BLACK;

            @Override
            public String toString() {
                return (this == RED) ? "RED" : "BLACK";
            }
        }

        private T key;
        private Node<T> left;
        private Node<T> right;
        private Node<T> parent;
        private Color color;

        private Node(T key, Node<T> left, Node<T> right, Node<T> parent, Color color) {
            this();
            this.key = key;
            this.left = left;
            this.right = right;
            this.parent = parent;
            this.color = color;
        }

        private Node() {}

        @Override
        public String toString() {
            return String.format(
                    "Key: %s ; Color: %s",
                    (key == null) ? "" : key,
                    (color == null) ? "" : color
            );
        }
    }
}
