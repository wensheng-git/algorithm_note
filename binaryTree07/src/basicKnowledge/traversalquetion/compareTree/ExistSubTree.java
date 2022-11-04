package basicKnowledge.traversalquetion.compareTree;

import java.util.ArrayList;

/**
 * @author :zhangwensheng
 * @date : 2022/11/2  0002 15:46
 */
public class ExistSubTree {
    public static void main(String[] args) {
    }
    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }
    public boolean isSubtree(Node root, Node subRoot) {
        // 递归每一个节点都去比较(递归遍历性)
        if(root==null&&subRoot!=null) return false;
        if(root!=null&&subRoot==null) return true;
        if(root==null&&subRoot==null) return true;
        return isSubtree(root.left,subRoot)||isSubtree(root.right,subRoot)||compare(root,subRoot);

    }

    public boolean compare(Node a, Node b){
        if(a==null&&b==null) return true;
        if(a!=null&&b==null) return false;
        if(a==null&&b!=null) return false;
        if(a.val!=b.val) return false;
        boolean leftTree=compare(a.left,b.left);
        boolean rightTree=compare(a.right,b.right);
        return leftTree&&rightTree;
    }
}
