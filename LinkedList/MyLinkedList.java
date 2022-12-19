class MyLinkedList
{
    Node head;
    private int size;

    class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    public void addFirst(String data) {
        Node newNode = new Node(data);

        if(head == null) {
            head = newNode;
            size++;
            return;
        }

        newNode.next = head;
        head = newNode;
        size++;
    }

    public void addLast(String data) {
        Node newNode = new Node(data);

        if(head == null) {
            head = newNode;
            size++;
            return;
        }

        Node curNode = head;
        while(curNode.next != null) {
            curNode = curNode.next;
        }
        curNode.next = newNode;
        size++;
    }

    public void printList() {
        if(head == null) {
            System.out.println("The list is empty.");
            return;
        }
        Node curNode = head;

        while(curNode != null) {
            System.out.print(curNode.data + " -> ");
            curNode = curNode.next;
        }

        System.out.println("null");
    }

    public void deleteFirst() {
        if(head == null) {
            System.out.println("The list is empty.");
            return;
        }
        
        head = head.next;
        size--;
    }

    public void deleteLast() {
        if(head == null) {
            System.out.println("The list is empty.");
            return;
        }

        size--;
        
        if(head.next == null) {
            head = null;
            return;
        }

        Node lastSecondNode = head;
        Node lastNode = head.next;

        while(lastNode.next != null) {
            lastSecondNode = lastSecondNode.next; //Not tested but plausible -> L2ndNode = lastNode;
            lastNode = lastNode.next;
        }

        lastSecondNode.next = null;
    }

    public void size() {
        System.out.println(size);
    }

    
    public void reverseIterate() {
        if(head == null || head.next == null) {
            return;
        }
        Node prevNode = head;
        Node curNode = prevNode.next;

        while(curNode != null) {
            Node nextNode = curNode.next;
            curNode.next = prevNode;

            prevNode = curNode;
            curNode = nextNode;
        }

        head.next = null;
        head = prevNode;
    }

    
    public Node reverseRecursion(Node curNode) {
        if(curNode == null || curNode.next == null) {
            head = curNode;
            return curNode;
        }
        //In Source, they didn't save last node as head,
        //instead saved the head directly during call,
        //check call statement in main for more info

        Node nextNode = reverseRecursion(curNode.next);
        /* nextNode.next =  curNode; //My method (Good Programming Practice)
        // The above line can also be written as below
        // If using below method, then no need to create
        // additional nextNode var, I haven't used it anywhere.
        // It only had use if I had executed above statment in comment
        */
        // simply call recursion without saving return value 
        curNode.next.next = curNode; //Source Method
        curNode.next = null;
        return curNode;
    }

    public Node deleteNLast(int n) {
        /*
        /can remove this because it will be 
        /handled by below test case where 
        /if(n == size)

        if(head.next == null) {
            head = null;
            return head;
        }
        */

        // Size of linked list
        Node curNode = head;
        int size = 0;
        while(curNode != null) {
            size++;
            curNode = curNode.next;
        }

        if(n == size) {
            head = head.next;
            return head;
        }

        int prevIndex = size - n;

        // Finding previous Node
        Node prevNode = head;
        for(int i = 1; i < prevIndex; i++) {
            prevNode = prevNode.next;
        }

        // Deleting nth Node from back
        prevNode.next = prevNode.next.next;
        return head;
    }


    public boolean palindromeCheck() {
        if(head == null || head.next ==  null) {
            return true;
        }
        int half_size = size / 2;

        Node curNode = head;
        Node secondHead = head;
        for(int i = 0; i < half_size; i++) {
            secondHead = secondHead.next;
        }
        if(size % 2 != 0) {
            secondHead = secondHead.next;
        }

        reverseRecursion(secondHead);
        //reverse method will automatically save last element as head
        secondHead = head;

        while(secondHead != null) {
            if(!curNode.data.equals(secondHead.data)) {
                return false;
            }
            curNode = curNode.next;
            secondHead = secondHead.next;
        }
        return true;
    }



    public static void main(String[] args)
    {
        MyLinkedList list = new MyLinkedList();

        list.addLast("0");
        list.addLast("1");
        list.addLast("2");
        list.addLast("3");
        list.addLast("3");
        list.addLast("2");
        list.addLast("1");
        list.addLast("0");
        // list.addLast("6");
        // list.addLast("7");

        System.out.println("Original List");
        list.printList();

        System.out.println(list.palindromeCheck());

        // list.deleteNLast(4);

        // System.out.println("New List");
        // list.printList();


        /* NOTE: 
        // list.reverseRecursion(list.head);

        //Alternate call method if you are not saving
        //new head in recursive function itself

        // list.head = list.reverseRecursion(list.head);
        */
    }
    
}