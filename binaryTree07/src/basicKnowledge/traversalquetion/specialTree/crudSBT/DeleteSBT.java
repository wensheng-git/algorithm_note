package basicKnowledge.traversalquetion.specialTree.crudSBT;

/**
 * @author :zhangwensheng
 * @date : 2022/11/3  0003 17:00
 *
 * TODO: BST搜索,找到
 *      左为null,删除节点的右孩子代替它,右为null,删除节点的左孩子代替它
 *      都不为null,先找到删除节点右孩子的最左的孩子,赋值给删除的节点,再去右边孩子删除最左的孩子
 */
public class DeleteSBT {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val=val;
        }
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;
        if(key<root.val) root.left=deleteNode(root.left,key);
        else if(key>root.val) root.right=deleteNode(root.right,key);
        else{ // ==key
            if(root.left==null) return root.right;
            if(root.right==null) return root.left;

            TreeNode temp=root.right;
            while(temp.left!=null){
                temp=temp.left;
            }
            root.val=temp.val;
            root.right=deleteNode(root.right,temp.val);
        }
        return root;
    }
}
