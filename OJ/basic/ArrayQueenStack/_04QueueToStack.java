package basic.ArrayQueenStack;


/**
 * 如何仅用队列结构实现栈结构？
 */

import java.util.LinkedList;
import java.util.Queue;

public class _04QueueToStack {

    public static class TwoQueuesToStack{
        private Queue<Integer> queue;
        private Queue<Integer> help;

        public TwoQueuesToStack(){
            queue = new LinkedList<>();
            help = new LinkedList<>();
        }

        public void push(int x){
            queue.add(x);
        }

        public int peek(){
            if (queue.isEmpty()){
                throw new RuntimeException("The queue is empty");
            }
            while (queue.size() > 1){
                help.add(queue.poll());
            }
            int res = queue.poll();
            help.add(res);
            swap();
            return res;
        }

        public int pop(){
            if (queue.isEmpty()){
                throw new RuntimeException("The queue is empty");
            }
            while (queue.size() > 1){
                help.add(queue.poll());
            }
            int res = queue.poll();
            swap();
            return res;
        }

        private void swap() {
            Queue<Integer> tmp = queue;
            queue = help;
            help = tmp;
        }

    }

    public static void main(String[] args) {

    }
}
