package basicKnowledge.serilizeAndconstructTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author :zhangwensheng
 * @date : 2022/11/1  0001 14:14
 *
 * PS:序列化不用将head==null的情况解耦出一个新方法,因为递归到最后的时候就是null
 *
 * TODO:
 *      前后序有序列化,中序有歧义不能进行序列化
 */
public class Serialize {
    // 前中后遍历,加null
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Queue<String> preSerial(Node head) {
        Queue<String> ans = new LinkedList<>();
        pres(head, ans);
        return ans;
    }

    public static void pres(Node head, Queue<String> ans) {
        if (head == null) {
            ans.add(null);
        } else {
            ans.add(String.valueOf(head.value));
            pres(head.left, ans);
            pres(head.right, ans);
        }
    }

    public static Queue<String> inSerial(Node head) {
        Queue<String> ans = new LinkedList<>();
        ins(head, ans);
        return ans;
    }

    public static void ins(Node head, Queue<String> ans) {
        if (head == null) {
            ans.add(null);
        } else {
            ins(head.left, ans);
            ans.add(String.valueOf(head.value));
            ins(head.right, ans);
        }
    }

    public static Queue<String> posSerial(Node head) {
        Queue<String> ans = new LinkedList<>();
        poss(head, ans);
        return ans;
    }

    public static void poss(Node head, Queue<String> ans) {
        if (head == null) {
            ans.add(null);
        } else {
            poss(head.left, ans);
            poss(head.right, ans);
            ans.add(String.valueOf(head.value));
        }
    }


    public static Queue<Node> level(Node head,Queue<Node> queue){
        Queue<Node> helpQue = new LinkedList<>();
        helpQue.add(head);
        queue.add(head);// 入队的时候序列化
        if (head==null) return queue;
        while(!helpQue.isEmpty()){
            Node poll = helpQue.poll();
            if (poll.left!=null){
                helpQue.add(poll.left);
                queue.add(poll.left);
            } else queue.add(null);
            if (poll.right!=null){
                helpQue.add(poll.right);
                queue.add(poll.right);
            } else queue.add(null);
        }
        return queue;
    }
}
