package basicKnowledge.recursionTricks;

import java.util.LinkedList;

/**
 * @author :zhangwensheng
 * @date : 2022/11/1  0001 16:41
 * TODO:
 *       完全二叉树:1~h-1层都是满二叉树,h层是从左到右塞的结点
 * 最后一层多种情况:()
 *    左子为满,右子为完全二叉,高度一样
 *    左子为完全二叉,右子为满,高度相差1
 * 并集Info:isBCT,isFull,height;
 */
public class isCBT {
    static class Node{
        int val;
        Node left;
        Node right;
        public Node(int val){
            this.val=val;
        }
    }
    static class Info{
        boolean isFull;
        boolean isBCT;
        int height;
        public Info(boolean isFull,boolean isBCT,int height){
            this.isFull=isFull;
            this.isBCT=isBCT;
            this.height=height;
        }
    }

    public static Info process(Node head){
        if (head==null)
            return new Info(true,true,0);
        Info leftInfo=process(head.left);
        Info rightInfo=process(head.right);

        int height=Math.max(leftInfo.height,rightInfo.height)+1;
        boolean isFull=false;
        if (leftInfo.isFull&& rightInfo.isFull&&leftInfo.height==rightInfo.height) isFull=true;
        boolean isBCT=false;
        // 两种情况
        if (leftInfo.isFull&& rightInfo.isBCT&&leftInfo.height== rightInfo.height) isBCT=true;
        if (leftInfo.isBCT&& rightInfo.isFull&&(leftInfo.height- rightInfo.height)==1) isBCT=true;
        return new Info(isFull,isBCT,height);
    }
    public static boolean isCBT2(Node head){
        return process(head).isBCT;
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
    public static boolean isCBT1(Node head) {
        if (head == null) {
            return true;
        }
        LinkedList<Node> queue = new LinkedList<>();
        // 是否遇到过左右两个孩子不双全的节点
        boolean leaf = false;
        Node l = null;
        Node r = null;
        queue.add(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            l = head.left;
            r = head.right;
            if (
                // 如果遇到了不双全的节点之后，又发现当前节点不是叶节点
                    (leaf && (l != null || r != null))
                            ||
                            (l == null && r != null)

            ) {
                return false;
            }
            if (l != null) {
                queue.add(l);
            }
            if (r != null) {
                queue.add(r);
            }
            if (l == null || r == null) {
                leaf = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int maxLevel = 5;
        int maxValue = 100;
        int testTimes = 1000000;
        for (int i = 0; i < testTimes; i++) {
            Node head = generateRandomBST(maxLevel, maxValue);
            if (isCBT1(head) != isCBT2(head)) {
                System.out.println("Oops!");
            }
        }
        System.out.println("finish!");
    }
}
