package basic.ArrayQueenStack;

import java.util.Stack;

/**
 * 如何仅用栈结构实现队列结构？
 */
public class _03StackToQueue {
    public static void main(String[] args) {
        Stack<Integer> stackPush = new Stack<>();
        Stack<Integer> stackPop = new Stack<>();
    }

    public void push(int pushNum, Stack<Integer> stack){
        stack.push(pushNum);
    }

    public int poll(Stack<Integer> stackPush, Stack<Integer> stackPop){
        if (stackPop.empty() && stackPush.empty()) {
            throw new RuntimeException("Queue is empty!");
        }
        else if(stackPop.empty()){
            while (!stackPush.empty()){
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.pop();
    }

    public int peek(Stack<Integer> stackPush, Stack<Integer> stackPop){
        if (stackPop.empty() && stackPush.empty()) {
            throw new RuntimeException("Queue is empty!");
        }
        else if (stackPop.empty()){
            while (!stackPush.empty()){
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.peek();
    }
}
