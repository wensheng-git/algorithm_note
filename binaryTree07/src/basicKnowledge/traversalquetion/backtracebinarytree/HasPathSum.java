package basicKnowledge.traversalquetion.backtracebinarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :zhangwensheng
 * @date : 2022/11/2  0002 23:29
 */
public class HasPathSum {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val=val;
        }
    }

    boolean has=false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        List<Integer> path=new ArrayList<>();
        traversal(root,targetSum,path);
        return has;
    }

    public void traversal(TreeNode root, int targetSum, List<Integer> path){
        if(root==null) return;
        path.add(root.val);
        // 叶子
        if(root.left==null&&root.right==null){
            int sum=0;
            for(int i: path){
                sum+=i;
            }
            if(sum==targetSum) {has=true;return;};
            return;
        }
        // 去看左边的分支..不判断为null的时候会直接返回,没有添加但是回溯删除了
        if(root.left!=null){
            traversal(root.left,targetSum,path);
            path.remove(path.size()-1);
        }
        // 去看右边的分支
        if(root.right!=null) {
            traversal(root.right,targetSum,path);
            path.remove(path.size()-1);
        }
    }
}
