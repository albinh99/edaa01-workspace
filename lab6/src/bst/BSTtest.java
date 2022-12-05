package bst;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import bst.BinarySearchTree;

public class BSTtest {

    private BinarySearchTree<Integer> tree;
    private BinarySearchTree<Integer> tree2;

    @BeforeEach
    void setUp(){
        tree = new BinarySearchTree<Integer>();
        tree2 = new BinarySearchTree<Integer>();
    }
    @AfterEach
    void tearDown(){
        tree = null;
        tree2 = null;
    }

    @Test
    void size(){
        tree.add(2);
        tree.add(5);
        tree.add(1);
        tree.add(6);
        assertEquals(4, tree.size());
    }

    @Test
    void height(){
        tree.add(2);
        tree.add(5);
        tree.add(1);
        tree.add(6);
        assertEquals(3,tree.height());

    }



}
