package basicKnowledge.recursionTricks;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Map;

/**
 * @author :zhangwensheng
 * @date : 2022/11/1  0001 23:22
 * TODO: 百分之10的错误
 * 解决思路:
 * 是二叉子树&&在是SBT时最大的nodes
 * info:
 * isSBT+[考虑本节点时]left.max,right.min ====TODO:考虑是不是的性质的时候,还要考虑本节点时怎么判断的,因此加了max和val
 * nodes
 *
 * 拓展:求出最大的子SB树的头结点,
 * Info
 * 信息中加入了一个SBhead,再计算head的时候设置
 */
public class MaxSubSBTSize {
    static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    static class Info {
        int max;
        int min;
        boolean isSBT;
        int nodes;

        public Info(int max, int min, boolean isSBT, int nodes) {
            this.max = max;
            this.min = min;
            this.isSBT = isSBT;
            this.nodes = nodes;
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
        int nodes=1;//左树的|右树的|本节点的
        if (leftInfo != null) {
            max = Math.max(max, leftInfo.max);
            min = Math.min(min, leftInfo.min);
            if (!leftInfo.isSBT || head.val <= leftInfo.max) isSBT = false;
            nodes=leftInfo.nodes;
        }
        if (rightInfo != null) {
            max = Math.max(max, rightInfo.max);
            min = Math.min(min, rightInfo.min);
            if (!rightInfo.isSBT || head.val >= rightInfo.min) isSBT = false;
            nodes=Math.max(nodes,rightInfo.nodes);
            if (leftInfo!=null&&leftInfo.isSBT&& rightInfo.isSBT&&leftInfo.max<head.val&&rightInfo.min>head.val) nodes=leftInfo.nodes+rightInfo.nodes+1;
        }
        return new Info( max, min,isSBT,nodes);
    }
    // 提交如下的largestBSTSubtree方法，可以直接通过
    public static int largestBSTSubtree(Node head) {
        if (head == null) {
            return 0;
        }
        return process(head).nodes;
    }
    
    
    
    // for test

    // 为了验证
    // 对数器方法
    public static int right(Node head) {
        if (head == null) {
            return 0;
        }
        int h = getBSTSize(head);
        if (h != 0) {
            return h;
        }
        return Math.max(right(head.left), right(head.right));
    }

    // 为了验证
    // 对数器方法
    public static int getBSTSize(Node head) {
        if (head == null) {
            return 0;
        }
        ArrayList<Node> arr = new ArrayList<>();
        in(head, arr);
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i).val <= arr.get(i - 1).val) {
                return 0;
            }
        }
        return arr.size();
    }

    // 为了验证
    // 对数器方法
    public static void in(Node head, ArrayList<Node> arr) {
        if (head == null) {
            return;
        }
        in(head.left, arr);
        arr.add(head);
        in(head.right, arr);
    }

    // 为了验证
    // 对数器方法
    public static Node generateRandomBST(int maxLevel, int maxValue) {
        return generate(1, maxLevel, maxValue);
    }

    // 为了验证
    // 对数器方法
    public static Node generate(int level, int maxLevel, int maxValue) {
        if (level > maxLevel || Math.random() < 0.5) {
            return null;
        }
        Node head = new Node((int) (Math.random() * maxValue));
        head.left = generate(level + 1, maxLevel, maxValue);
        head.right = generate(level + 1, maxLevel, maxValue);
        return head;
    }

    // 为了验证
    // 对数器方法
    public static void main(String[] args) {
        int maxLevel = 1000000;
        int maxValue = 100000;
        int testTimes = 100;
        int count=0;
        System.out.println("测试开始");
        for (int i = 0; i < testTimes; i++) {
            Node head = generateRandomBST(maxLevel, maxValue);
            if (largestBSTSubtree(head) != right(head)) {
                System.out.println("出错了！");
                count++;
            }
        }
        System.out.println("测试结束");
        System.out.println(count);
    }
}
