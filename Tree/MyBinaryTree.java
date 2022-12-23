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

    //Height of tree
    public int height(Node curNode) {
        if(curNode == null) {
            return 0;
        }

        int leftHeight = height(curNode.left);
        int rightHeight = height(curNode.right);

        int count = Math.max(leftHeight, rightHeight) + 1;

        return count;
    }

    //Diameter of tree --> time complexity --> O(n2)
    public int n2diameter(Node curNode) {
        if(curNode == null) {
            return 0;
        }

        int leftD = n2diameter(curNode.left);
        int rightD = n2diameter(curNode.right);
        int centerD = height(curNode.left) + height(curNode.right) + 1;

        return Math.max(Math.max(leftD, rightD), centerD);
    }

    //Diameter of tree --> Optimized method for time complexity of O(n)
    //My Code
    // class NodeInfo {
    //     int diameter;
    //     int height;
    // }

    // public NodeInfo diameter(Node curNode) {
    //     NodeInfo data = new NodeInfo();

    //     if(curNode == null) {
    //         data.diameter = 0;
    //         data.height = 0;
    //         return data;
    //     }

    //     NodeInfo left = diameter(curNode.left);
    //     NodeInfo right = diameter(curNode.right);
    //     int diam = left.height + right.height + 1;

    //     data.diameter = Math.max(diam, Math.max(left.diameter, right.diameter));
    //     data.height = Math.max(left.height, right.height) + 1;

    //     return data;
    // }

    //Source Code
    class TreeInfo {
        int ht;
        int diam;

        TreeInfo(int ht, int diam) {
            this.ht = ht;
            this.diam = diam;
        }
    }

    public TreeInfo diameter2(Node root) {
        if(root == null) {
            return new TreeInfo(0, 0);
        }

        TreeInfo left = diameter2(root.left);
        TreeInfo right = diameter2(root.right);

        int myHeight = Math.max(left.ht, right.ht) + 1;

        int diam1 = left.diam;
        int diam2 = right.diam;
        int diam3 = left.ht + right.ht + 1;

        int mydiam = Math.max(Math.max(diam1, diam2), diam3);

        TreeInfo myInfo = new TreeInfo(myHeight, mydiam);
        return myInfo;
    }

    public Boolean isEquivalent(Node Main, Node Sample) {
        if(Main == null && Sample == null) {
            return true;
        }

        if(Main == null || Sample == null) {
            return false;
        }

        if(Main.data == Sample.data) {
            return isEquivalent(Main.left, Sample.left) && isEquivalent(Main.right, Sample.right);
        }

        return false;
    }

    public Boolean checkSubTree(Node Main, Node Sample) {
        if(Sample == null) {
            return true;
        }

        if(Main == null) {
            return false;
        }

        if(Main.data == Sample.data) {
            if(isEquivalent(Main, Sample)) {
                return true;
            }
        }

        return checkSubTree(Main.left, Sample) || checkSubTree(Main.right, Sample);
    }


    public static void main(String[] args) {
        MyBinaryTree tree = new MyBinaryTree();

        // int[] arr = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        int[] arr = {4, 1, 2, -1, -1, 8, 1, 2, -1, -1, 3, -1, -1, 9, -1, -1, 5, 6, -1, -1, 7, -1, -1};

        tree.createTree(arr);
        tree.levelorder(tree.root);
        System.out.println();
        System.out.println("Number of Nodes = " + tree.countNodes(tree.root));
        System.out.println("Sum of Nodes = " + tree.sumNodes(tree.root));
        System.out.println("Height of tree = " + tree.height(tree.root));
        System.out.println("Diameter of tree(N2 method) = " + tree.n2diameter(tree.root));
        // System.out.println("Diameter of tree(N method) = " + tree.diameter(tree.root).diameter);
        System.out.println("Diameter of tree(N methdo) = " + tree.diameter2(tree.root).diam);

        MyBinaryTree subtree = new MyBinaryTree();
        int[] arr2 = {1,2,-1,-1,3,-1,-1};
        subtree.createTree(arr2);

        System.out.println(tree.checkSubTree(tree.root, subtree.root));
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