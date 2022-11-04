package basicKnowledge.traversalquetion.specialTree.preAndcurNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :zhangwensheng
 * @date : 2022/11/3  0003 15:36
 */
public class ModeNumsOfSBT {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val=val;
        }
    }



    int count=0;
    int maxCount=0;
    List<Integer> result=new ArrayList<>();
    TreeNode pre;
    public int[] findMode(TreeNode root) {
        // 依旧使用前节点和后面节点的比较,如果一样count++,不一样或者pre为null,count=1
        // 每次对count处理完一次要更新最大的count,大于maxCount,意味着有更高频率树的出现,等于就证明出现了多个众数
        traversal(root);
        int[] ans=new int[result.size()];
        for(int i=0;i<ans.length;i++) ans[i]=result.get(i);
        return ans;
    }
    public void traversal(TreeNode root){
        if(root==null) return;
        traversal(root.left);


        if(pre==null||root.val!=pre.val) count=1;
        else  count++;
        if(count>maxCount){
            result.clear();
            result.add(root.val);
            maxCount=count;
        }
        else if(count==maxCount) result.add(root.val);
        pre=root;

        traversal(root.right);

    }
}
