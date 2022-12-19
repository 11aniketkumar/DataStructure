import java.util.Stack;

class StackCollection {

    static Stack<Integer> s = new Stack<>();

    public static void pushAtBottom(int x) {
        if(!s.isEmpty()) {
            int a = s.pop();
            pushAtBottom(x);
            s.push(a);
            return;
        }
        s.push(x);
    }

    public static void reverseStack() {
        for(int i = 0; i < s.size(); i++) {
            pushAtBottom(s.pop());
        }
    }

    public static void printStack() {
        while(!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }

    public static void  main(String[] args) {
        s.push(0);
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        pushAtBottom(5);
        System.out.println(s.size());
        reverseStack();
        printStack();
    }
}