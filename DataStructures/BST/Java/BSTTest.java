public class BSTTest {
    public static void main(String[] args) {
        BST bst = new BST();
        bst.print();
        bst.insert(8);
        bst.insert(-8);
        bst.insert(10);
        bst.insert(16);
        bst.insert(20);
        bst.insert(17);
        bst.insert(128);
        bst.insert(126);
        bst.insert(127);
        bst.insert(6);
        bst.insert(3);
        bst.insert(1);
        bst.insert(2);
        bst.insert(7);
        if(!bst.contains(20) || !bst.contains(126) || !bst.contains(8) || bst.contains(-1)) {
            System.out.println("Error: contains method is NOT working");
        }
        try {
            System.out.println("min: " + bst.min() + ", max: " + bst.max());
        } catch (Exception e) {
        }
        bst.print();
        
        bst.delete(8);
        bst.print();
        bst.delete(10);
        bst.print();
        bst.delete(2);
        bst.delete(6);
        bst.delete(3);
        bst.print();
        bst.delete(20);
        bst.print();
        bst.insert(126);
        bst.insert(126);
        bst.insert(126);
        bst.insert(126);
        bst.print();
        bst.deleteAll(126);
        bst.print();
        try {
            System.out.println("min: " + bst.min() + ", max: " + bst.max());
        } catch (Exception e) {
        }
    }
}