//implementation of queue using linkedlist

class QueueLL {
    Node head;
    Node tail;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public boolean isEmpty() {
        if(head == null) {
            return true;
        }
        return false;
    }

    public void add(int data) {
        Node curNode = new Node(data);

        if(isEmpty()) {
            head = curNode;
            tail = head;
            return;
        }

        tail.next = curNode;
        tail = curNode;
    }

    public int remove() {
        if(isEmpty()) {
            return -1;
        }

        if(head.next == null) {
            tail = null;
        }

        int data = head.data;
        head = head.next;
        return data;
    }

    public int peek() {
        if(isEmpty()) {
            return -1;
        }
        return head.data;
    }

    public static void main(String[] args) {
        QueueLL list = new QueueLL();

        list.add(1);
        list.add(3);

        System.out.println(list.peek());
        list.remove();

        list.add(3);
        System.out.println(list.peek());
    }
}