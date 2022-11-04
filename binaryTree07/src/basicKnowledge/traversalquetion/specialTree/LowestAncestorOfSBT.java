package basicKnowledge.traversalquetion.specialTree;

/**
 * @author :zhangwensheng
 * @date : 2022/11/3  0003 16:00
 */
public class LowestAncestorOfSBT {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val=val;
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //从上到下遍历,遇到的第一个在pq区间的节点一定是最近祖先
        //如果不是最近祖先,证明两个节点在同一个棵子树,那么本节点就是不可能在该区间,矛盾
        if(root==null) return null;
        if(root.val<p.val&&root.val<q.val) return lowestCommonAncestor(root.right,p,q);
        if(root.val>p.val&&root.val>q.val) return lowestCommonAncestor(root.left,p,q);
        return root;
    }
}
