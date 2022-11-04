package basicKnowledge.traversalquetion.compareTree;


/**
 * @author :zhangwensheng
 * @date : 2022/11/2  0002 15:08
 */
public class isSameTree {
    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }
    public boolean isSameTree(Node p, Node q) {
        return compare(p,q);
    }

    public boolean compare(Node a, Node b){
        if(a==null&&b==null) return true;
        if(a!=null&&b==null) return false;
        if(a==null&&b!=null) return false;
        if(a.val!=b.val) return false;

        boolean leftTree=compare(a.left,b.left);
        boolean rightTree=compare(a.right,b.right);
        boolean result=leftTree&&rightTree;
        return result;
    }
}
