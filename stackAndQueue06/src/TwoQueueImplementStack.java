import java.util.LinkedList;
import java.util.Queue;

/**
 * @author :zhangwensheng
 * @date : 2022/10/31  0031 0:38
 */
public class TwoQueueImplementStack {
    static class MyStack {
        // 两个队列:一个队列弹出length-1的元素给另一个队列,最后把剩下的返回,然后交换队列
        // 一个队列:一个队列弹出length-1的元素加入到本队列尾巴,然后弹出剩下的元素
        Queue<Integer> que1;
        Queue<Integer> que2;
        public MyStack() {
            que1=new LinkedList<>();
            que2=new LinkedList<>();
        }

        public void push(int x) {
            que1.add(x);
        }

        public int pop() {
            int len=que1.size()-1;
            while(len-->0) que2.add(que1.poll());
            Queue<Integer> que=que1;
            que1=que2;
            que2=que;
            return que2.poll();
        }

        public int top() {
            int len=que1.size()-1;
            while(len-->0) que2.add(que1.poll());
            int result=que1.poll();
            que2.add(result);
            Queue<Integer> que=que1;
            que1=que2;
            que2=que;
            return result;
        }

        public boolean empty() {
            return que1.isEmpty();
        }
    }

}
