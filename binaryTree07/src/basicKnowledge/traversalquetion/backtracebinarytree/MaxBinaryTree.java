package basicKnowledge.traversalquetion.backtracebinarytree;

/**
 * @author :zhangwensheng
 * @date : 2022/11/3  0003 12:35
 *
 * TODO:一般涉及遍历的,
 *      终止条件是null特殊情况去改动,
 *      一般会新建立一个函数去作为递归的函数,因为原给定的函数不一定有足够多的参数
 *      对于需要多层递归共享的变量设置到全局变量中
 */
public class MaxBinaryTree {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val=val;
        }
    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums,0,nums.length-1);
    }

    public TreeNode build(int[] nums,int left,int right){
        if(left>right) return null;
        int max=getMax(nums,left,right);
        TreeNode maxNode=new TreeNode(nums[max]);
        maxNode.left=build(nums,left,max-1);
        maxNode.right=build(nums,max+1,right);
        return maxNode;
    }

    public int getMax(int[] arr,int left,int right){
        int max=left;
        for (int i=left+1;i<=right;i++){
            max=arr[max]<arr[i]?i:max;
        }
        return max;
    }
}
