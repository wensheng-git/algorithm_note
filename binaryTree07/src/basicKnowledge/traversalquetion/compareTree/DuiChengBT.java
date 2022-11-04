package basicKnowledge.traversalquetion.compareTree;

/**
 * @author :zhangwensheng
 * @date : 2022/11/2  0002 14:48
 */
public class DuiChengBT {
    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }
    
    // 先序和后序回文(中左右等于中右左)
    public boolean isSymmetric(Node root) {
        return compare(root.left,root.right);
    }

    public boolean compare(Node left,Node right){
        if(left==null&&right==null) return true;
        if(left!=null&&right==null) return false;
        if(left==null&&right!=null) return false;
        if(left.val!=right.val) return false;

        // 比较
        boolean outSide=compare(left.left,right.right);
        boolean inSide=compare(left.right,right.left);
        boolean result=outSide&&inSide;
        return result;
    }

}
