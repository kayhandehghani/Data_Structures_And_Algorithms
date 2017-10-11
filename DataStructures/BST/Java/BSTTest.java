import java.util.List;

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

        // testing getLevelList
        List<List<Integer>> levelList = bst.getLevelList();
        for(int i = 0; i < levelList.size(); i++) {
            System.out.print("Level " + i + " : " );
            for(int val : levelList.get(i)) {
                System.out.print(val + ", " );
            }
            System.out.println();
        }

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
        System.out.println("\nin-orde traversal:\n");
        bst.inOrderPrint();
        System.out.println("\npre-orde traversal:\n");
        bst.preOrderPrint();
        System.out.println("\npost-orde traversal:\n");
        bst.postOrderPrint();
        try {
            System.out.println("min: " + bst.min() + ", max: " + bst.max());
        } catch (Exception e) {
        }
        System.out.println(bst.isBalanaced());
        bst.clear();
        bst.insert(8);
        bst.insert(6);
        bst.insert(17);
        bst.insert(-1);
        System.out.println(bst.isBalanaced()); // true
        bst.insert(-8);
        System.out.println(bst.isBalanaced()); // false
        bst.insert(2);
        bst.insert(7);
        bst.insert(14);
        bst.insert(11);
        bst.insert(20);
        System.out.println("\nin-orde traversal:\n");
        bst.inOrderPrint();
        System.out.println("\npre-orde traversal:\n");
        bst.preOrderPrint();
        System.out.println("\npost-orde traversal:\n");
        bst.postOrderPrint();
    }
}