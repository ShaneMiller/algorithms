//TODO: Use testing framework
public class BinarySearchTreeTest {
    public static void main(String[] args) {
        BinarySearchTree<Character> binarySearchTree = new BinarySearchTree<Character>();
        binarySearchTree.insert('H');
        binarySearchTree.insert('E');
        binarySearchTree.insert('L');
        binarySearchTree.insert('L');
        binarySearchTree.insert('O');
        binarySearchTree.insert('W');
        binarySearchTree.insert('O');
        binarySearchTree.insert('R');
        binarySearchTree.insert('L');
        binarySearchTree.insert('D');

        if(!binarySearchTree.recursiveSearch('R').toString().equals("R")) {
            throw new RuntimeException();
        } else if(binarySearchTree.recursiveSearch('Z') != null) {
            throw new RuntimeException();
        } else if(!binarySearchTree.iterativeSearch('L').toString().equals("L")) {
            throw new RuntimeException();
        } else if(binarySearchTree.iterativeSearch('P') != null) {
            throw new RuntimeException();
        }

        binarySearchTree.inOrderWalk();
        System.out.println("Maximum: " + binarySearchTree.maximum(binarySearchTree.getRoot()));
        System.out.println("Minimum: " + binarySearchTree.minimum(binarySearchTree.getRoot()));

        System.out.println("'D' Successor: " + binarySearchTree.successor(binarySearchTree.iterativeSearch(binarySearchTree.getRoot(), 'D')));
        System.out.println("'O' Successor: " + binarySearchTree.successor(binarySearchTree.iterativeSearch(binarySearchTree.getRoot(), 'O')));
        System.out.println("'R' Successor: " + binarySearchTree.successor(binarySearchTree.iterativeSearch(binarySearchTree.getRoot(), 'R')));

        System.out.println("'D' Predecessor: " + binarySearchTree.predecessor(binarySearchTree.iterativeSearch(binarySearchTree.getRoot(), 'D')));
        System.out.println("'O' Predecessor: " + binarySearchTree.predecessor(binarySearchTree.iterativeSearch(binarySearchTree.getRoot(), 'O')));
        System.out.println("'W' Predecessor: " + binarySearchTree.predecessor(binarySearchTree.iterativeSearch(binarySearchTree.getRoot(), 'W')));


        binarySearchTree.delete(binarySearchTree.iterativeSearch('R'));
        binarySearchTree.inOrderWalk();
    }
}