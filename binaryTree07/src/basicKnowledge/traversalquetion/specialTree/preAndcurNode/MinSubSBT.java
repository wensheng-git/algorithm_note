package basicKnowledge.traversalquetion.specialTree.preAndcurNode;

import javax.swing.tree.TreeNode;

/**
 * @author :zhangwensheng
 * @date : 2022/11/3  0003 15:08
 */
public class MinSubSBT {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val=val;
        }
    }
    int result=Integer.MAX_VALUE;
    TreeNode pre=null;
    public int getMinimumDifference(TreeNode root) {
        traversal(root);
        return result;
    }
    public void traversal(TreeNode root){
        //中序遍历[有序数组]过程抓到前一个节点和本节点就可以了
        if(root==null) return;
        getMinimumDifference(root.left);
        if(pre!=null)
            result=Math.min(result,Math.abs(root.val-pre.val));//我的pre是上一次的抓的
        //重点************抓前一个节点
        pre=root;//第一次if不能进去,然后我先抓到你,等你返回的给父亲的时候,我抓到的就是你,和父亲pk
        getMinimumDifference(root.right);
    }
}
