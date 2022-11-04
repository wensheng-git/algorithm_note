package basicKnowledge.recursionTricks;

import javax.swing.tree.TreeNode;

/**
 * @author :zhangwensheng
 * @date : 2022/11/1  0001 16:21
 */
public class isBalanced {
    static class Node{
        int val;
        Node left;
        Node right;
        public Node(int val){
            this.val=val;
        }
    }

    public boolean isBalanced(Node root) {
        //得到答案的可能性就是一种:本节点是不是balanced
        //子树信息:子树是不是平衡,子树高度
        return process(root).isBalanced;
    }
    class Info{
        boolean isBalanced;
        int height;
        public Info(int height,boolean isBalanced){
            this.height=height;
            this.isBalanced=isBalanced;
        }
    }
    public Info process(Node root){
        if(root==null) return new Info(0,true);
        Info leftInfo=process(root.left);
        Info rightInfo=process(root.right);
        // int height = Math.max(leftInfo.height, rightInfo.height)  + 1;
        int height=Math.max(leftInfo.height,rightInfo.height) +1;
        boolean isBalanced=true;
        if(!leftInfo.isBalanced||!rightInfo.isBalanced||Math.abs(leftInfo.height-rightInfo.height)>1)
            isBalanced=false;
        return new Info(height,isBalanced);
    }
}
