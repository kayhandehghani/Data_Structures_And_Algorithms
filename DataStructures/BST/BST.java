import java.util.ArrayList;
import java.util.Stack;
import java.util.List;

/**
 * @summary: simple implementation of a Binary Search Tree of integers
 * @author: Kayhan Dehghani
 **/
public class BST {
    private Node root;

    public boolean isBalanaced() {
        return (maxDepth(root) - minDepth(root) <= 1);
    }

    private int maxDepth(Node node) {
        if(node == null) return 0;
        return 1 + Math.max(maxDepth(node.lChild), maxDepth(node.rChild));
    }

    private int minDepth(Node node) {
        if(node == null) return 0;
        return 1 + Math.min(minDepth(node.lChild), minDepth(node.rChild));
    }

    public void insert(int value) {
        Node newNode = new Node(value);
        if(root != null) {
            Node currentNode = root;
            while(true) {
                if(value <= currentNode.value) {
                    if(currentNode.lChild == null) { // has no left child
                        currentNode.lChild = newNode;
                        return;
                    }
                    currentNode = currentNode.lChild;
                } else {
                    if(currentNode.rChild == null) {
                        currentNode.rChild = newNode;
                        return;
                    }
                    currentNode = currentNode.rChild;
                }
            }
        } else {
            root = newNode;
        }
    }

    public int min() throws IllegalAccessException {
        try {
            int min = root.value;
            Node currentNode = root;
            while(currentNode.lChild != null) {
                currentNode = currentNode.lChild;
                min = currentNode.value;
            }
            return min;
        } catch (Exception e) {
            throw new IllegalAccessException("Empty BST");
        }
    }
    
    public int max() throws IllegalAccessException {
        try {
            int max = root.value;
            Node currentNode = root;
            while(currentNode.rChild != null) {
                currentNode = currentNode.rChild;
                max = currentNode.value;
            }
            return max;
        } catch (Exception e) {
            throw new IllegalAccessException("Empty BST");
        }
    }

    // inefficient implementation of removing all instances of nodes with key = value
    public void deleteAll(int value) {
        while(contains(value)) {
            delete(value);
        }
    }

    // delete the first instance of a node with key = value
    public void delete(int value) {
        if(root != null) {
            Node currentNode = root;
            Node parent = root;
            Node replacingNode = null;

            // search for the node with key = value
            while(currentNode != null && currentNode.value != value) {
                parent = currentNode;
                if(value < currentNode.value) {
                    currentNode = currentNode.lChild;
                } else {
                    currentNode = currentNode.rChild;
                }
            }

            // determine a node to replace the deleted node
            if(currentNode != null) { // currentNode has key = value
                if(currentNode.lChild != null && currentNode.rChild != null) { // has two children
                    Node[] nodes = successor(currentNode);
                    Node successor = nodes[0];
                    Node successorParent = nodes[1];
                    if(successorParent == currentNode) { // successor is the right child of currentNode
                        replacingNode = successor;
                        replacingNode.lChild = currentNode.lChild;
                    } else { 
                        currentNode.value = successor.value;
                        successorParent.lChild = successor.rChild; // equivalent to delete successor
                        return;
                    }
                } else if(currentNode.lChild != null) { // has only left child
                    replacingNode = currentNode.lChild;
                } else if(currentNode.rChild != null) { // has only right child
                    replacingNode = currentNode.rChild;
                }
                // replace the deleted node
                if(currentNode == root) {
                    root = replacingNode;
                } else if(currentNode == parent.lChild) {
                    parent.lChild = replacingNode;
                } else if(currentNode == parent.rChild)  {
                    parent.rChild = replacingNode;
                }
            }
        }
    }

    // returns the successor in right sub tree and its parent
    private Node[] successor(Node node) {
        Node parent = null;
        Node successor = node;
        if(successor != null && successor.rChild != null) {
            parent = successor;
            successor = successor.rChild;
            while(successor.lChild != null) {
                parent = successor;
                successor = successor.lChild;
            }
        }
        return new Node[] {successor, parent};
    }

    public void clear() {
        root = null;
    }

    public boolean contains(int value) {
        return hasValue(root, value);
    }

    // recursive helper function for contains method
    private boolean hasValue(Node root, int value) {
        if(root == null) {
            return false;
        } else if(root.value == value) {
            return true;
        } else {
            return hasValue(root.lChild, value) || hasValue(root.rChild, value);
        }
    }

    // returns a list of n lists: the inner lists contain all the nodes at each level
    // n is the depth of the tree
    public List<List<Integer>> getLevelList() {
        int level = 0;
        List<List<Node>> levelList = new ArrayList<>();
        List<Node> currentList = new ArrayList<>();
        Node currentNode = root;
        currentList.add(root);
        levelList.add(level, currentList);
        while(true) {
            currentList = new ArrayList<>();
            for(int i = 0; i < levelList.get(level).size(); i++) {
                currentNode = levelList.get(level).get(i);
                if(currentNode.lChild != null) {
                    currentList.add(currentNode.lChild);
                }
                if(currentNode.rChild != null) {
                    currentList.add(currentNode.rChild);
                }
            }
            if(currentList.isEmpty()) {
                break;
            } 
            levelList.add(++level, currentList);
        }
        
        // return only the values not the nodes
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> intList;
        for(List<Node> l : levelList) {
            intList = new ArrayList<>();
            for(Node n : l) {
                intList.add(n.value);
            }
            result.add(intList);
        }
        return result;
    }

    // non-recursive
    public void inOrderPrint() {
        System.out.print("[ ");
        if(root != null) {
            Stack<Node> s = new Stack<>();
            Node current = root;
            while(true) {
                // push the root.left to stack
                while(current != null) {
                    s.push(current);
                    current = current.lChild;
                }
                if(!s.isEmpty()) {
                    current = s.pop();
                    System.out.print(current.value + " ");
                    current = current.rChild;
                } else {
                    break; // stack is empty: all nodes have been visited
                }
            }
        }
        System.out.print(" ]\n\n");
    }
    
    // non-recursive
    public void preOrderPrint() {
        System.out.print("[ ");
        if(root != null) {
            Stack<Node> s = new Stack<>();
            Node current = root;
            s.push(current);
            while(!s.isEmpty()) {
                current = s.pop();
                System.out.print(current.value + " ");
                if(current.rChild != null) {
                    s.push(current.rChild);
                } 
                if(current.lChild != null) {
                    s.push(current.lChild);
                } 
            }
        }
        System.out.print(" ]\n\n");
    }
    
    // non-recursive
    public void postOrderPrint() {
        System.out.print("[ ");
        if(root != null) {
            Stack<Node> traverseStack = new Stack<>();
            Stack<Node> mainStack = new Stack<>();
            Node current = root;
            traverseStack.push(current);
            while(!traverseStack.isEmpty()) {
                current = traverseStack.pop();
                mainStack.push(current); // leave the current node (self) to be printed later
                if(current.lChild != null) {
                    traverseStack.push(current.lChild);
                }
                if(current.rChild != null) {
                    traverseStack.push(current.rChild);
                }
            }
            while(!mainStack.isEmpty()) {
                System.out.print(mainStack.pop().value + " ");
            }
        }
        System.out.print(" ]\n\n");
    }

    public void print() {
        System.out.print("[ ");
        printHelper(root);
        System.out.print("]\n");
    }

    private void printHelper(Node root) {
        if(root != null) {
            printHelper(root.lChild);
            System.out.print(root.value + " ");
            printHelper(root.rChild);
        }
    }

    class Node {
        Node lChild;
        Node rChild;
        int value;

        Node(int value) {
            this.value = value;
        }
    }
}