package basicKnowledge.dfs;

/**
 * @author :zhangwensheng
 * @date : 2022/11/1  0001 9:59
 */
public class RecursionTraversal {
    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    // Recursion:三种排序其实有六种遍历方式:3!
    public void pre(Node head) {
        if (head == null) return;
        System.out.println(head.val);
        pre(head.left);
        pre(head.right);
    }

    public void in(Node head) {
        if (head == null) return;
        in(head.left);
        System.out.println(head.val);
        in(head.right);
    }

    public void pos(Node head) {
        if (head == null) return;
        pos(head.left);
        pos(head.right);
        System.out.println(head.val);
    }
}
