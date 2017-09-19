/**
 * @summary: simple implementation of a Binary Search Tree of integers
 * @author: Kayhan Dehghani
 **/
public class BST {
    private Node root;

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
                    try {
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
                    } catch (Exception e) {
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
    private Node[] successor(Node node) throws IllegalAccessException {
        try {
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
        } catch (Exception e) {
            throw new IllegalAccessException("sucessor: empty tree");
        }
    }

    public boolean contains(int value) {
        return hasValue(root, value);
    }

    // recursive helper function for contains method
    private boolean hasValue(Node root, int value) {
        if(root == null) {
            return false;
        }else if(root.value == value) {
            return true;
        } else {
            return hasValue(root.lChild, value) || hasValue(root.rChild, value);
        }
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