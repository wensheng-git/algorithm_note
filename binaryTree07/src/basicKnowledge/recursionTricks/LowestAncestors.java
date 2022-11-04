package basicKnowledge.recursionTricks;

/**
 * @author :zhangwensheng
 * @date : 2022/11/2  0002 9:04
 *
 * 思考可能模型:
 *      传递了两个节点,子树有了两个节点(子树root是两个节点|子树是一个节点&子树的子树有一个节点,子树的子树有两个节点)
 *                  记录ancestor返回
 */
public class LowestAncestors {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val=val;
        }
    }
    class Info{
        boolean hasA;
        boolean hasB;
        TreeNode ancestor;
        public Info(boolean hasA,boolean hasB, TreeNode ancestor){
            this.hasA=hasA;
            this.hasB=hasB;
            this.ancestor=ancestor;
        }
    }
    public Info process(TreeNode a, TreeNode b, TreeNode head){
        if (head==null) return new Info(false,false,null);
        Info leftInfo=process(a,b,head.left);
        Info rightInfo=process(a,b,head.right);
        boolean hasA=(head==a)|| leftInfo.hasA|| rightInfo.hasA;
        boolean hasB=(head==b)|| leftInfo.hasB|| rightInfo.hasB;
        TreeNode ancestor=null;
        if (hasA&&hasB) {
            if (leftInfo.ancestor==null&&rightInfo.ancestor==null) ancestor=head;
            else ancestor=leftInfo.ancestor==null?rightInfo.ancestor: leftInfo.ancestor;
        }
        return new Info(hasA,hasB,ancestor);
    }
}
