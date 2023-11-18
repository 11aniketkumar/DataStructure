// Self made Array List program //

// I don't think this is the conventional way or best way
// there might be many missing corner cases
// People can implement ArrayList in different ways
// and this was me just trying to create a array list
// for the first time using my own logic

// Please refer some online source to learn best or conventional
// method acceptable or atleast best method

class MyArrayList
{
    int size;
    int[] arr;
    int pos;

    MyArrayList() {
        this.size = 10;
        newArrayList(this.size);
    }

    MyArrayList(int size) {
        this.size = size;
        newArrayList(this.size);
    }

    public void newArrayList(int size) {
        int[] arr = new int[size];

        if(this.arr == null) {
            this.arr = arr;
            return;
        }
        
        for(int i = 0; i < this.size; i++) {
            arr[i] = this.arr[i];
        }

        this.size = size;
        this.arr = arr;
    }

    public void addItem(int x) {
        if(pos < size) {
            this.arr[pos] = x;
            pos++;
        } else {
            int size = this.size + ((int)(this.size/2)) + 1;
            newArrayList(size);
            addItem(x);
        }
    }

    public int getItem(int index) {
        return this.arr[index];
    }

    public void pop() {
        if(this.arr == null) {
            return;
        }

        int last_index = this.pos - 1;
        this.arr[last_index] =  0;
        this.pos--;
    }

    public void deleteItem(int index) {
        if(index < this.pos) {
            int[] arr = new int[this.size];

            for(int i = 0; i < index; i++) {
                arr[i] = this.arr[i];
            }
            
            for(int i = index; i < this.pos - 1; i++) {
                arr[i] = this.arr[i + 1];
            }

            this.pos--;
            this.arr = arr;
        }
    }

    public void clear() {
        int[] arr = new int[this.size];
        this.arr = arr;
        this.pos = 0;
    }

    public void printList() {
        for(int i = 0; i < this.size; i++) {
            System.out.print(this.arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MyArrayList list = new MyArrayList(4);

        list.addItem(1);
        list.addItem(2);
        list.addItem(3);
        list.addItem(4);
        list.addItem(5);
        list.addItem(6);
        list.addItem(7);
        list.addItem(8);
        list.addItem(9);
        list.printList();
        list.deleteItem(2);
        list.printList();
        list.deleteItem(5);
        list.printList();
        System.out.println(list.getItem(3));
        list.clear();
        list.printList();
    }
}