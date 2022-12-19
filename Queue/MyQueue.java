import java.util.Scanner;

public class MyQueue {
    int rear;
    int size;
    int[] arr;

    MyQueue() {
        this(10);
    }

    MyQueue(int size) {
        this.size = size;
        this.arr = new int[size];
        this.rear = -1;
    }

    public boolean isEmpty() {
        return rear == -1;
    }

    //enqueue
    public void add(int x) {
        if(rear < size - 1) {
            rear++;
            arr[rear] = x;
        } else {
            System.out.println("add operation failed, queue is full.");
            return;
        }
    }

    //dequeue
    public int remove() {
        if(isEmpty()) {
            System.out.println("The Queue is empty.");
            return rear; //returning -1
        } else {
            int front = arr[0];
            for(int i = 0; i < rear; i++) {
                arr[i] = arr[i+1];
            }
            rear--;
            return front;
        }
    }

    public int peek() {
        if(isEmpty()) {
            System.out.println("The Queue is empty.");
            return -1; //or returning rear i.e equal to -1
        }
        return arr[0];
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        MyQueue queue = new MyQueue();

        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);
        queue.add(7);
        queue.add(8);
        queue.add(9);
        queue.add(10);
        queue.add(11);

        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.peek());
    }
}