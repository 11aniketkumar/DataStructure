import java.util.*;

class MyBinaryTree {
    Node root;
    int index;

    class Node {
        int data;
        Node left;
        Node right;
    }

    public Node createTree(int[] arr) {
        Node curNode = new Node();

        if(index == 0) {
            root = curNode;
        }

        if(arr[index] == -1) {
            index++;
            return null;
        }

        curNode.data = arr[index++];
        curNode.left = createTree(arr);
        curNode.right = createTree(arr);

        if(curNode == root) {
            index = 0;
        }
        return curNode;
    }

    public void preorder(Node curNode){
        if(curNode == null){
            // System.out.print("-1 "); //You can print -1 for null if you want;
            return;
        }

        System.out.print(curNode.data + " ");
        preorder(curNode.left);
        preorder(curNode.right);
    }

    public void inorder(Node curNode){
        if(curNode == null){
            // System.out.print("-1 "); //You can print -1 for null if you want;
            return;
        }

        inorder(curNode.left);
        System.out.print(curNode.data + " ");
        inorder(curNode.right);
    }

    public void postorder(Node curNode){
        if(curNode == null){
            // System.out.print("-1 "); //You can print -1 for null if you want;
            return;
        }

        postorder(curNode.left);
        postorder(curNode.right);
        System.out.print(curNode.data + " ");
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

    public void printLevel(int level, Node curNode, int i) {
        if(curNode == null) {
            return;
        }
        if(i == level) {
            System.out.print(curNode.data + " ");
            return;
        }
        i++;
        printLevel(level, curNode.left, i);
        printLevel(level, curNode.right, i);
    }


    // =========================================================================
    //                                PROBLEMS
    // =========================================================================
    
    //count number of nodes in tree
    public int countNodes(Node root) {
        if(root == null) {
            return 0;
        }

        int leftNodes = countNodes(root.left);
        int rightNodes = countNodes(root.right);

        return leftNodes + rightNodes + 1;
    }

    //sum of nodes data
    public int sumNodes(Node root) {
        if(root == null) {
            return 0;
        }

        int leftSum = sumNodes(root.left);
        int rightSum = sumNodes(root.right);

        return leftSum + rightSum + root.data;
    }

    //number of levels
    public int numLevel(Node curNode) {
        if(curNode == null) {
            return 0;
        }

        int leftHeight = numLevel(curNode.left);
        int rightHeight = numLevel(curNode.right);

        int count = Math.max(leftHeight, rightHeight) + 1;

        return count;
    }

    public static void main(String[] args) {
        MyBinaryTree tree = new MyBinaryTree();

        int[] arr = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};

        tree.createTree(arr);
        tree.levelorder(tree.root);
        System.out.println();
        System.out.println(tree.countNodes(tree.root));
        System.out.println(tree.sumNodes(tree.root));
        System.out.println(tree.numLevel(tree.root));
    }


    // public static void main(String[] args) {
    //     MyBinaryTree tree = new MyBinaryTree();

    //     int[] arr = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};

    //     tree.createTree(arr);
    //     // tree.preorder(tree.root);
    //     // System.out.println();
    //     // tree.inorder(tree.root);
    //     // System.out.println();
    //     // tree.postorder(tree.root);
    //     // System.out.println();
    //     // tree.printLevel(1, tree.root, 1);
    //     // tree.levelorder(3, tree.root);

    //     tree.levelorder(tree.root);
    // }
}