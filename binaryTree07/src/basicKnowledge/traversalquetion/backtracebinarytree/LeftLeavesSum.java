package basicKnowledge.traversalquetion.backtracebinarytree;

/**
 * @author :zhangwensheng
 * @date : 2022/11/2  0002 21:11
 *
 * TODO:对于题目,{{我们想象在遍历的时候抓到题目要的信息}},然后每层都收集好,向上返回
 *
 * TODO:左叶子就是,只有叶子的父亲才可以判断,
 */
public class LeftLeavesSum {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val=val;
        }
    }
    public int sumOfLeftLeaves(TreeNode root) {
        // 一个节点的左节点不为null,它左节点的左节点为null,左节点的右节点为null,则左节点的左节点为左左叶子
        if(root==null) return 0;
        //
        int leftVal=sumOfLeftLeaves(root.left);
        if(root.left!=null && root.left.left==null && root.left.right==null) leftVal=root.left.val;
        int rightVal=sumOfLeftLeaves(root.right);
        return  leftVal+rightVal;
    }

}
