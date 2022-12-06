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


        tree.add(10);
        tree.add(15);
        tree.add(19);
        tree.add(22);
        tree.add(24);
        tree.add(27);


        tree2.add(p1);
        tree2.add(p2);

        bst.drawTree(tree);
        //tree2.printTree();

    }
}
