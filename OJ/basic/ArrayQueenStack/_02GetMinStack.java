package basic.ArrayQueenStack;

/**
 * 实现一个特殊的栈， 在实现栈的基本功能的基础上， 再实现返
 * 回栈中最小元素的操作。
 * 【 要求】
 * 1． pop、 push、 getMin操作的时间复杂度都是O(1)。
 * 2． 设计的栈类型可以使用现成的栈结构。
 */

import java.util.Stack;

public class _02GetMinStack {

    public static class Stack1{
        private Stack<Integer> StackDate;
        private Stack<Integer> StackMin;

        public Stack1(){
            this.StackDate = new Stack<>();
            this.StackMin = new Stack<>();
        }

        public void push(int newNum){
            if (StackMin.isEmpty()){
                StackMin.push(newNum);
            }
            else if (newNum <= StackMin.peek()){
                StackMin.push(newNum);
            }
            StackDate.push(newNum);
        }

        public int pop(){
            if (StackDate.isEmpty()){
                throw new RuntimeException("Your stack is empty");
            }
            int x = StackDate.pop();
            if (x == this.getMin()){
                StackMin.pop();
            }
            return x;
        }

        private int getMin() {
            if (StackMin.isEmpty()){
                throw new RuntimeException("Your stack is empty");
            }
            return this.StackMin.peek();
        }
    }

    public static void main(String[] args) {

    }
}
