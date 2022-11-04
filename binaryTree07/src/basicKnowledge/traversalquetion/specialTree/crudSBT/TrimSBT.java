package basicKnowledge.traversalquetion.specialTree.crudSBT;

/**
 * @author :zhangwensheng
 * @date : 2022/11/3  0003 17:30
 */
public class TrimSBT {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val=val;
        }
    }
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        //小于区间 我们丢弃这个节点,但是右子树可能是有区间的节点
        if (root.val < low) {
            return trimBST(root.right, low, high);
        }
        //大于区间 我们丢弃,但是左子树是可能有区间的节点
        if (root.val > high) {
            return trimBST(root.left, low, high);
        }
        // root在[low,high]范围内:直接重构就可以了
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }
}
