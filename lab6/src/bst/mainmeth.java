package bst;

import equals.Person;

public class mainmeth {
    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        BinarySearchTree<Person> tree2 = new BinarySearchTree<Person>((p1, p2) -> p1.getName().compareTo(p2.getName()));
        BinarySearchTree<Person> tree3 = new BinarySearchTree<Person>((p1, p2) -> p1.getId() - p2.getId());
        Person p1 = new Person("Albin", 123);
        Person p2 = new Person("Ludvig", 321);
        BSTVisualizer bst = new BSTVisualizer("Träd", 500, 300);


        tree.add(1);
        tree.add(2);
        tree.add(3);
        tree.add(4);
        tree.add(5);
        tree.add(6);
        tree.add(7);
        tree.add(8);
        tree.add(9);
        tree.add(10);
        tree.add(11);
        tree.add(12);


        tree.rebuild();

        bst.drawTree(tree);
        //tree2.printTree();

    }
}
