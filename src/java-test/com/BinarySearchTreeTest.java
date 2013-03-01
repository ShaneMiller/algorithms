package com;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.mockito.InOrder;

import java.util.Arrays;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class BinarySearchTreeTest {

    @Test
    public void testRecursiveSearch() throws Exception {
        BinarySearchTree<Character> tree = new BinarySearchTree<Character>(Arrays.asList('H', 'E', 'L', 'L', 'O', 'W', 'O', 'R', 'L', 'D'));
        assertTrue(tree.recursiveSearch('R').toString().equals("R"));
        assertNull(tree.recursiveSearch('Z'));
    }

    @Test
    public void testIterativeSearch() throws Exception {
        BinarySearchTree<Character> tree = new BinarySearchTree<Character>('H');
        tree.insert('E');
        tree.insert('L');
        tree.insert('L');
        tree.insert('O');
        assertTrue(tree.iterativeSearch('E').toString().equals("E"));
        assertNull(tree.iterativeSearch('Z'));
    }

    @Test
    public void maximum() throws Exception {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        tree.insert(1);
        tree.insert(7);
        tree.insert(9);
        tree.insert(2);
        tree.insert(8);
        assertEquals(tree.maximum(tree.getRoot()).toString(), Integer.toString(9));
    }

    @Test
    public void minimum() throws Exception {
        BinarySearchTree<Character> tree = new BinarySearchTree<Character>(Arrays.asList('H', 'E', 'L', 'L', 'O', 'W', 'O', 'R', 'L', 'D'));
        assertEquals(tree.minimum(tree.getRoot()).toString(), "D");
    }

    @Test
    public void successor() throws Exception {
        BinarySearchTree<Character> tree = new BinarySearchTree<Character>(Arrays.asList('H', 'E', 'L', 'L', 'O', 'W', 'O', 'R', 'L', 'D'));
        BinarySearchTree.Node<Character> dNode = tree.iterativeSearch(tree.getRoot(), 'D');
        BinarySearchTree.Node<Character> oNode = tree.iterativeSearch(tree.getRoot(), 'O');
        BinarySearchTree.Node<Character> rNode = tree.iterativeSearch(tree.getRoot(), 'R');

        assertEquals(tree.successor(dNode).toString(), "E");
        assertEquals(tree.successor(oNode).toString(), "O");
        assertEquals(tree.successor(rNode).toString(), "W");
    }

    @Test
    public void predecessor() throws Exception {
        BinarySearchTree<Character> tree = new BinarySearchTree<Character>(Arrays.asList('H', 'E', 'L', 'L', 'O', 'W', 'O', 'R', 'L', 'D'));
        BinarySearchTree.Node<Character> dNode = tree.iterativeSearch(tree.getRoot(), 'D');
        BinarySearchTree.Node<Character> oNode = tree.iterativeSearch(tree.getRoot(), 'O');
        BinarySearchTree.Node<Character> wNode = tree.iterativeSearch(tree.getRoot(), 'W');

        assertNull(tree.predecessor(dNode));
        assertEquals(tree.predecessor(oNode).toString(), "L");
        assertEquals(tree.predecessor(wNode).toString(), "R");
    }

    @Test
    public void delete() throws Exception {
        BinarySearchTree<Character> tree = new BinarySearchTree<Character>(Arrays.asList('H', 'E', 'L', 'L', 'O', 'W', 'O', 'R', 'L', 'D'));
        assertEquals(tree.delete(tree.iterativeSearch('R')).toString(), "R");
        assertNull(tree.iterativeSearch('R'));
    }


    @Test
    public void testInOrderWalk() throws Exception {
        Logger mock = mock(Logger.class);
        InOrder inOrder = inOrder(mock);

        BinarySearchTree<Character> tree = new BinarySearchTree<Character>(Arrays.asList('H', 'E', 'L', 'L', 'O', 'W', 'O', 'R', 'L', 'D'));
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
}
