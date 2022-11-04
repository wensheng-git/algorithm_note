package basicKnowledge.dfs;

import com.sun.xml.internal.bind.v2.TODO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * @author :zhangwensheng
 * @date : 2022/11/1  0001 10:43
 * TODO:总结
 *      前序+后序=====借助了访问顺序和遍历顺序一样
 *      中序:cur指针为遍历顺序,整个树分解为若干左枝树;
 */
public class unRecursionTraversal {
    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    // 借助栈:压栈序:打印中间(弹出就打印)-->压入右-->压入左
    public void pre(Node head) {
        Stack<Node> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            System.out.println(pop.val);// 先处理弹出的本节点
            if (pop.right != null) stack.push(pop.right);
            if (pop.left != null) stack.push(pop.left);
        }
    }

    // 后序:左右中==>中右左==>稍微改动前序的代码
    public void pos(Node head) {
        Stack<Node> stack = new Stack<>();
        ArrayList<Node> result = new ArrayList<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            result.add(pop);
            if (pop.left != null) stack.push(pop.left);
            if (pop.right != null) stack.push(pop.right);
        }
        // TODO 反转result
    }

    // 中序:它先处理左节点,而我们先访问中间节点,所以访问顺序和打印顺序不一样,不能借助前序了
    // cur来记录访问的顺序
    // TODO:过程:
    // 整个树分解为左树
    // 每次压入左树,所以弹出的时候是left head
    // 每次抓到了head,去压入head.right的左枝树
    // 顺序为:left-->head-->right
    public void in(Node head) {
        Stack<Node> stack = new Stack<>();
        Node cur = head;
        while (cur != null || !stack.isEmpty()) { // cur不为null是因为t弹出了root节点,没有处理右树,stack已经是null了
            // 左枝树
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }else{
                cur=stack.pop();
                System.out.println(cur.val);
                // 中节点的右树-->变为左枝树
                cur=cur.right;
            }
        }
    }

}
