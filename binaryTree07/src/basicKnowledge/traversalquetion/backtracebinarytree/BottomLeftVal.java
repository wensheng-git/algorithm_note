package basicKnowledge.traversalquetion.backtracebinarytree;

/**
 * @author :zhangwensheng
 * @date : 2022/11/2  0002 21:51
 */
public class BottomLeftVal {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val=val;
        }
    }



    //全局变量类似Info类型(不过这里递归第一次到达就要把值处理信息,所以好像不能用Info模板的后序遍历)
    //模板2:不能用Info模板的,可以将信息放在全局变量中,先序遍历的方式去改变全局变量,最后把全局变量返回
    // 当收集的信息只为一个的时候,可以借助递归返回直接处理,而不用借用Info/全局变量
    int Deep;
    int leftVal;
    public int findBottomLeftValue(TreeNode root) {
        leftVal=root.val;
        traversal(root,1);
        return leftVal;
    }
    public void traversal(TreeNode root,int deep){
        if(root==null) return;
        // 叶子的时候去收集
        if(root.left==null&&root.right==null){
            if(deep>Deep){
                leftVal=root.val;
                Deep=deep;
            }
            return ;
        }
        traversal(root.left,++deep);
        deep--;
        traversal(root.right,++deep);
    }
}
