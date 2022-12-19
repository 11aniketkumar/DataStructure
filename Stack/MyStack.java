class MyStack {
    Node head;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = head;
        }
    }

    public void push(int data) {
        head = new Node(data);
    }

    public int peek() {
        if(head == null) {
            System.out.println("The stack is empty.");
            return -1;
        }
        System.out.println(head.data);
        return head.data;
    }

    public int pop() {
        if(head == null) {
            return -1;
        }
        int temp = head.data;
        head = head.next;
        return temp;
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();

        stack.push(0);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        stack.peek();
        System.out.println("deleting - " + stack.pop());
        stack.peek();

        stack.push(89);
        stack.peek();
    }
}