package basicKnowledge.traversalquetion.compareTree;

import javax.swing.tree.TreeNode;

/**
 * @author :zhangwensheng
 * @date : 2022/11/3  0003 12:47
 */
public class MergeBinaryTree {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val=val;
        }
    }
    // 把root2覆盖到root1中
    // 一起遍历,一层逻辑左相加操作,终止条件有几种可能列出
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1==null&&root2==null) return null;
        if(root1!=null&&root2==null) return root1;
        if(root1==null&&root2!=null) return root2;//直接把root2的分支设置回去

        root1.val+=root2.val;
        root1.left=mergeTrees(root1.left,root2.left);
        root1.right=mergeTrees(root1.right,root2.right);
        return root1;
    }
}
