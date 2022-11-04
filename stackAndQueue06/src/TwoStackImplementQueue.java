import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author :zhangwensheng
 * @date : 2022/10/31  0031 0:17
 *
 * TODO:
 *      有一个关键优化:inToOut(只有outStack为空才把inStack的东西倒入)
 *      pop和peek的时候才调用inToOut方法(涉及出的操作才去调用)
 */
public class TwoStackImplementQueue {
     static class MyQueue {
        private Stack<Integer> stack1;
        private Stack<Integer> stack2;
        public MyQueue() {
            stack1=new Stack<>();
            stack2=new Stack<>();

        }

        public void push(int x) {
            stack1.push(x);
        }

        public void inToOut(){
            // TODO:关键优化:我有元素了,你不用倒过来,我空了,你再倒入
            if(!stack2.isEmpty()) return;
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }

        public int pop() {
            //    while(!stack1.isEmpty()){
            //        stack2.push(stack1.pop());
            //    }
            //    int result=stack2.pop();
            //    while(!stack2.isEmpty()){
            //        stack1.push(stack2.pop());
            //    }
            inToOut();
            return stack2.pop();

        }

        public int peek() {
            //     while(!stack1.isEmpty()){
            //        stack2.push(stack1.pop());
            //    }
            //    int result=stack2.peek();
            //    while(!stack2.isEmpty()){
            //        stack1.push(stack2.pop());
            //    }
            inToOut();
            return stack2.peek();
        }

        public boolean empty() {
            return stack1.isEmpty()&&stack2.isEmpty();
        }
    }
}
