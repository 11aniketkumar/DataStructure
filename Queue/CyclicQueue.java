class CyclicQueue{
    int front;
    int rear;
    int[] arr;

    CyclicQueue() {
        this(10);
    }

    CyclicQueue(int size) {
        this.arr = new int[size];
        this.front = -1;
        this.rear = -1;
    }

    public boolean isEmpty(){
        if((front == -1) && (rear == -1)) {
            return true;
        }
        return false;
    }

    public boolean isFull(){
        return (front == (rear + 1) % arr.length);
    }

    public void add(int x) {
        if(isFull()) {
            System.out.println("Queue full!");
            return;
        }
        if(isEmpty()) {
            front = 0;
        }

        rear = (rear + 1) % arr.length;
        this.arr[rear] = x;
    }

    public void remove() {
        if(isEmpty()) {
            return;
        }

        if(front == rear) {
            this.front = -1;
            this.rear = -1;
            return;
        }

        this.front = (front + 1) % arr.length;
    }

    public void display() {
        int i = this.front;
        while(i != this.rear) {
            System.out.print(this.arr[i] + " ");
            i = (i + 1) % arr.length;
        }
        System.out.println(this.arr[this.rear]);
    }

    public static void main(String[] args) {
        CyclicQueue q = new CyclicQueue(5);

        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(5);

        q.remove();
        q.remove();

        q.add(7);
        
        q.display();
    }
}