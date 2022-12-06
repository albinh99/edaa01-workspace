package bst;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import equals.Person;



import bst.BinarySearchTree;

public class BSTtest {

    private BinarySearchTree<Integer> tree;
    private BinarySearchTree<Person> tree2;
    private BinarySearchTree<Person> tree3;


    @BeforeEach
    void setUp(){
        tree = new BinarySearchTree<Integer>();
        tree2 = new BinarySearchTree<Person>((p1, p2) -> p1.getName().compareTo(p2.getName()));
        tree3 = new BinarySearchTree<Person>((p1, p2) -> p1.getId() - p2.getId());

    }
    @AfterEach
    void tearDown(){
        tree = null;
        tree2 = null;
        tree3 = null;
    }

    @Test
    void size(){
        assertEquals(0, tree.size());
        tree.add(2);
        tree.add(5);
        tree.add(1);
        tree.add(6);
        assertEquals(true, tree.add(7));
        assertEquals(false, tree.add(1));
        assertEquals(5, tree.size());
    }

    @Test
    void height(){
        assertEquals(0, tree.height());
        tree.add(2);
        tree.add(5);
        tree.add(1);
        tree.add(6);
        assertEquals(3,tree.height());
        Person p1 = new Person("Albin", 123);
        Person p2 = new Person("Ludvig", 321);
        tree2.add(p1);
        tree2.add(p2);
        assertEquals(2,tree2.height());



    }
    @Test
    void clear(){
        tree.add(2);
        tree.add(5);
        tree.add(1);
        tree.add(6);
        assertEquals(4, tree.size());
        tree.clear();
        assertEquals(null, tree.root);
        assertEquals(0, tree.size());
    }

    @Test
    void add(){
        tree.add(1);
        tree.add(1);
        assertEquals(1, tree.size());
        assertEquals(false, tree.add(1));
        assertEquals(true, tree.add(2));
        Person p1 = new Person("Albin", 123);
        Person p2 = new Person("Ludvig", 321);
        Person p3 = new Person("Ludvig", 123);
        tree2.add(p1);
        tree2.add(p2);
        assertEquals(2, tree2.size());
        assertEquals(false, tree2.add(p3));
        tree3.add(p1);
        tree3.add(p2);
        assertEquals(false, tree3.add(p3));
        tree3.add(p3);
        assertEquals(2, tree3.size());



    }



}
