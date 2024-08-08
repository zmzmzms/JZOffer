package TopCode.栈和队列;

import java.util.PriorityQueue;
import java.util.Stack;
import java.util.TreeSet;

public class MinStack {
    private PriorityQueue<Integer> priorityQueue;
    private Stack<Integer> stack;
    public MinStack() {
        this.stack = new Stack<>();
        this.priorityQueue = new PriorityQueue<>();
    }

    public void push(int val) {
        stack.push(val);
        priorityQueue.add(val);
    }

    public void pop() {
        Integer top = stack.pop();
        priorityQueue.remove(top);
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return priorityQueue.peek();
    }
}

//class MinStack2{
//    private Stack<Integer> minStack;
//    private Stack<Integer> stack;
//    public MinStack2() {
//        this.stack = new Stack<>();
//        this.minStack = new Stack<>();
//    }
//
//    public void push(int val) {
//
//    }
//
//    public void pop() {
//
//    }
//
//    public int top() {
//
//    }
//
//    public int getMin() {
//
//    }
//}
