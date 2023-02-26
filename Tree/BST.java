import java.util.*;

public class BST {
    Node root = null;
    ArrayList<Integer> path_list = new ArrayList<>();

    private class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public Node insert(Node root, int val) {
        if(root == null) {
            root = new Node(val);
            return root;
        }

        if(val < root.data) {
            root.left = insert(root.left, val);
        } else if(val > root.data) {
            root.right = insert(root.right, val);
        }

        return root;
    }

    public void inorder(Node root) {
        if(root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public boolean search(Node root, int key) {
        if(root == null) {
            return false;
        }

        if(root.data == key) {
            return true;
        } else if(key < root.data) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }

    public Node delete(Node root, int val) {
        if(val < root.data) {
            root.left = delete(root.left, val);
        } else if(val > root.data) {
            root.right = delete(root.right, val);
        } 
        
        else { // root.data == val
            //case 1
            if((root.left == null) && (root.right == null)) {
                return null;
            }

            //case 2
            if(root.left == null) {
                return root.right;
            } else if(root.right == null) {
                return root.left;
            }

            //case 3
            Node IS = inorderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }

        return root;
    }

    public Node inorderSuccessor(Node root) {
        while(root.left != null) {
            root = root.left;
        }

        return root;
    }

    public void levelorder(Node curNode) {
        Queue<Node> q = new LinkedList<>();
        q.add(curNode);
        q.add(null);

        while(q.size() != 1) {
            Node front = q.remove();
            if(front == null) {
                System.out.println();
                q.add(null);
                continue;
            }
            System.out.print(front.data + " ");
            if(front.left != null) {
                q.add(front.left);
            }
            if(front.right != null) {
                q.add(front.right);
            }
        }
    }

    public void printInRange(Node root, int X, int Y) {
        if(root == null) {
            return;
        }

        if((root.data >= X) && (root.data <= Y)) {
            printInRange(root.left, X, Y);
            System.out.print(root.data + " ");
            printInRange(root.right, X, Y);
        } else if(root.data < X) {
            printInRange(root.right, X, Y);
        } else if(root.data > Y) {
            printInRange(root.left, X, Y);
        }
    }

    public void printAllPath(Node root) {
        if(root == null) {
            return;
        }

        path_list.add(root.data);

        if(root.left == null && root.right == null) {
            //printing path
            for(int i: path_list) {
                System.out.print(i + "->");
            }
            System.out.println();
        } else {
            printAllPath(root.left);
            printAllPath(root.right);
        }

        path_list.remove(path_list.size() - 1);
    }


    public static void main(String args[]) {
        BST tree = new BST();

        int arr[] = {7,5,2,3,1,6,4,9,15,20,12};

        for(int i = 0; i < arr.length; i++) {
            tree.root = tree.insert(tree.root, arr[i]);
        }

        System.out.println(tree.root);

        // tree.inorder(tree.root);
        // tree.levelorder(tree.root);
        // System.out.println(tree.search(tree.root, 7));

        // tree.root = tree.delete(tree.root, 2);
        tree.inorder(tree.root);
        // tree.levelorder(tree.root);

        System.out.println();
        tree.printInRange(tree.root, 4, 12);

        System.out.println("\n================================================");
        tree.printAllPath(tree.root);
    }
}