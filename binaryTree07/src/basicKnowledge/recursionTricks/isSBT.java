package basicKnowledge.recursionTricks;

import java.util.ArrayList;

/**
 * @author :zhangwensheng
 * @date : 2022/11/1  0001 22:23
 * <p>
 * 搜索二叉树:左<中<右----------TODO:不能等于
 * 可能性:子树是BST&&left.max<=cur.val<=right.min
 */
public class isSBT {
    static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }
    static class Info {
        boolean isSBT;
        int max;
        int min;
        public Info(boolean isSBT, int max, int min) {
            this.isSBT = isSBT;
            this.max = max;
            this.min = min;
        }
    }

    public static Info process(Node head) {
        // 终止条件不能确定new
        if (head == null) return null;
        // 直接收集
        Info leftInfo = process(head.left);
        Info rightInfo = process(head.right);
        //加工信息,用左右信息的时候要判断不能为null
        // 默认值为一个节点的时候
        boolean isSBT = true;
        int max = head.val;
        int min = head.val;
        if (leftInfo != null) {
            max = Math.max(max, leftInfo.max);
            min = Math.min(min, leftInfo.min);
            if (!leftInfo.isSBT || head.val <= leftInfo.max) isSBT = false;
        }
        if (rightInfo != null) {
            max = Math.max(max, rightInfo.max);
            min = Math.min(min, rightInfo.min);
            if (!rightInfo.isSBT || head.val >= rightInfo.min) isSBT = false;
        }
        return new Info(isSBT, max, min);
    }

    public static boolean isBST2(Node head) {
        if (head == null) return true;
        return process(head).isSBT;
    }


    // for test
    public static boolean isBST1(Node head) {
        if (head == null) {
            return true;
        }
        ArrayList<Node> arr = new ArrayList<>();
        in(head, arr);
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i).val <= arr.get(i - 1).val) {
                return false;
            }
        }
        return true;
    }

    public static void in(Node head, ArrayList<Node> arr) {
        if (head == null) {
            return;
        }
        in(head.left, arr);
        arr.add(head);
        in(head.right, arr);
    }


    // for test
    public static Node generateRandomBST(int maxLevel, int maxValue) {
        return generate(1, maxLevel, maxValue);
    }

    // for test
    public static Node generate(int level, int maxLevel, int maxValue) {
        if (level > maxLevel || Math.random() < 0.5) {
            return null;
        }
        Node head = new Node((int) (Math.random() * maxValue));
        head.left = generate(level + 1, maxLevel, maxValue);
        head.right = generate(level + 1, maxLevel, maxValue);
        return head;
    }

    public static void main(String[] args) {
        int maxLevel = 4;
        int maxValue = 100;
        int testTimes = 1000000;
        for (int i = 0; i < testTimes; i++) {
            Node head = generateRandomBST(maxLevel, maxValue);
            if (isBST1(head) != isBST2(head)) {
                System.out.println("Oops!");
            }
        }
        System.out.println("finish!");
    }
}
