package datastructures.tree.binarytree;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.mockito.InOrder;

import java.util.Arrays;

import static org.mockito.Mockito.*;

public class RedBlackTreeTest {
    @Test
    public void testInOrderWalk() throws Exception {
        RBTree rbtree = new RBTree();
        rbtree.insert('H');
        rbtree.insert('E');
        rbtree.insert('L');
        rbtree.insert('L');
        rbtree.insert('O');
        rbtree.insert('W');
        rbtree.insert('O');
        rbtree.insert('R');
        rbtree.insert('L');
        rbtree.insert('D');


        Logger mock = mock(Logger.class);
        InOrder inOrder = inOrder(mock);

        RedBlackTree<Character> tree = new RedBlackTree<Character>(Arrays.asList('H', 'E', 'L', 'L', 'O', 'W', 'O', 'R', 'L', 'D'));
        tree.log = mock;
        tree.inOrderWalk();

        inOrder.verify(mock).info('D');
        inOrder.verify(mock).info('E');
        inOrder.verify(mock).info('H');
        inOrder.verify(mock, times(3)).info('L');
        inOrder.verify(mock, times(2)).info('O');
        inOrder.verify(mock).info('R');
        inOrder.verify(mock).info('W');
    }

    @Test
    public void blah() throws Exception {

        RBTree rbtree = new RBTree();
        RedBlackTree<Double> tree = new RedBlackTree<Double>();
        for(double i = 1; i < 100; i++) {
            rbtree.insert(i);
            tree.insert(i);
        }

        tree.inOrderWalk();
    }
}
