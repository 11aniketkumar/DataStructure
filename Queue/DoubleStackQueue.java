import java.util.*;

public class DoubleStackQueue
{
    Stack<Integer> s1 = new Stack<>();
	Stack<Integer> s2 = new Stack<>();
	
	public void insert(int val) {
	    while(!s1.isEmpty()) {
	        s2.push(s1.pop());
	    }
	    
	    s1.push(val);
	    
	    while(!s2.isEmpty()) {
	        s1.push(s2.pop());
	    }
	}
	
	public int delete() {
	    if(s1.isEmpty()) {
	        System.out.println("Queue Empty!");
	        return -1;
	    }
	    
	    return s1.pop();
	}
	
	public int display() {
	    if(s1.isEmpty()) {
	        System.out.println("Queue Empty!");
	        return -1;
	    }
	    
	    System.out.println(s1.peek());
	    return s1.peek();
	}
	
	public static void main(String[] args) {
	    DoubleStackQueue queue = new DoubleStackQueue();
	    
	    queue.insert(1);
	    queue.insert(2);
	    queue.insert(3);
	    queue.display();
	    queue.delete();
	    queue.display();
	    queue.insert(4);
	    queue.insert(5);
	    queue.display();
	    queue.delete();
	    queue.delete();
	    queue.delete();
	    queue.delete();
	    queue.display();
	}
}
