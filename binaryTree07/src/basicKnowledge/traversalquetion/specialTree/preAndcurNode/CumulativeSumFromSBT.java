package basicKnowledge.traversalquetion.specialTree.preAndcurNode;

/**
 * @author :zhangwensheng
 * @date : 2022/11/3  0003 17:59
 */
public class CumulativeSumFromSBT {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val=val;
        }
    }

    int pre=0;
    public TreeNode convertBST(TreeNode root) {//遍历直接改变的东西,不用新建立方法
        //把右子树的加上自己作为自己的值
        //每个节点都要这样,从右边的叶子开始
        //右中左..
        if(root==null) return null;
        convertBST(root.right);
        //抓到右孩子(右孩子是右孩子+自己的值)...每个节点都这么设置,就是累加和
        root.val+=pre;
        pre=root.val;
        convertBST(root.left);
        return root;
    }
}
