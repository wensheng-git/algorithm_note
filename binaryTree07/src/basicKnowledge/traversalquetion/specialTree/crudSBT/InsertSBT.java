package basicKnowledge.traversalquetion.specialTree.crudSBT;

import javax.swing.tree.TreeNode;

/**
 * @author :zhangwensheng
 * @date : 2022/11/3  0003 16:22
 */
public class InsertSBT {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val=val;
        }
    }
    public TreeNode insertIntoBST(TreeNode root, int val) {
        //按照二叉树的遍历去构建二叉树
        if(root==null) return new TreeNode(val);
        if(val>=root.val) root.right=insertIntoBST(root.right,val);
        if(val<root.val) root.left=insertIntoBST(root.left,val);
        return root;
    }
}
