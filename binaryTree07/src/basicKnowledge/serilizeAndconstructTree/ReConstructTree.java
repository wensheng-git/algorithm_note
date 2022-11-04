package basicKnowledge.serilizeAndconstructTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author :zhangwensheng
 * @date : 2022/11/1  0001 14:17
 *
 * TODO 序列化和反序列化总结:
 *      1:写head==null情况
 *      2:写遍历的模板去序列化或者反序列化PS:层序需要借助两个队列,一个队列模拟遍历,一个队列代表序列化的结果信息
 */
public class ReConstructTree {
    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    //TODO:构建的时候:访问到了哪个元素就一定先把它构建出来然后处理它的左右子树,所以中序遍历现在还没有构建
    //先序;先构建本节点,再递归调用构建左右节点
    public static Node pre(Queue<Node> que){
        if (que==null||que.isEmpty()) return null;
        //正常构建
        Node poll=null;
        while(!que.isEmpty()){
            poll = que.poll();
            poll.left=pre(que);
            poll.right=pre(que);
        }
        return poll;
    }

    //后序..先变==>中右左.
    public static Node pos(Queue<Node> queue){
        if (queue==null||queue.isEmpty()) return null;
        Stack<Node> stack=new Stack<>();
        while(!queue.isEmpty()){
            stack.push(queue.poll());
        }
        return build(stack);
    }
    public static Node build(Stack<Node> stack){
        Node head=null;
        while(!stack.isEmpty()){
            head=stack.pop();
            head.right=build(stack);
            head.left=build(stack);
        }
        return  head;
    }


    //层序反序列化
    public static Node buildByLevel(Queue<Node> levelQueue){
        if (levelQueue==null||levelQueue.isEmpty()) return null;
        //借助一个队列,模拟遍历的过程,遍历过程顺便序列化
        Queue<Node> queue=new LinkedList<>();
        Node head=levelQueue.poll();
        if (head!=null) queue.add(head);
        while(queue.isEmpty()){
            Node poll = queue.poll();
            poll.left=levelQueue.poll();
            poll.right=levelQueue.poll();
            // 只有不是null的我才加入我的遍历队列中
            if (poll.left!=null) queue.add(poll.left);
            if (poll.right!=null) queue.add(poll.right);
        }
        return head;
    }


}
