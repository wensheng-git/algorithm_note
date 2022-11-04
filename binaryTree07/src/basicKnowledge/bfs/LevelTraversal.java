package basicKnowledge.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author :zhangwensheng
 * @date : 2022/11/1  0001 13:02
 * <p>
 * 两种实现:
 * 1:借助队列
 * 让头加入que:
 * 出队列,出一个加入它的left和right(一层弹出后,下一层刚刚好加入了)
 * 2:借助队列发现新层
 *   每迭代完一层,记录本队列的size(),因为本size就是下一层的结点数
 */
public class LevelTraversal {
    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void traversal1(Node head) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            System.out.println(poll.val);
            if (poll.left != null) {
                queue.add(poll.left);
            }
            if (poll.right != null) {
                queue.add(poll.right);
            }
        }
    }

    public static void traversal2(Node head){
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()) {
            int len=queue.size();
            while (len-- > 0) {
                Node poll = queue.poll();
                System.out.print(poll.val+"  ");
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
            System.out.println("一层到了");
        }
    }

    public static void main(String[] args) {
        Node node1=new Node(1);
        Node node2=new Node(2);
        Node node3=new Node(3);
        Node node4=new Node(4);
        Node node5=new Node(5);
        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        node2.right=node5;
        traversal2(node1);
    }

}
