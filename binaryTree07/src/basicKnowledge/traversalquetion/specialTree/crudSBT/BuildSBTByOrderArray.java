package basicKnowledge.traversalquetion.specialTree.crudSBT;

/**
 * @author :zhangwensheng
 * @date : 2022/11/3  0003 17:34
 * 数组的中间作为我们的头节点,左右去重新构
 * TODO:
 *       rebuild的机制都是拿到本节点,然后去构建左右孩子
 */
public class BuildSBTByOrderArray {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val=val;
        }
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums,0,nums.length-1);
    }
    public TreeNode build(int[] nums,int left,int right){
        //两元素去测试边界值
        if(left>right) return null;
        int mid=left+(right-left)/2;
        TreeNode midNode=new TreeNode(nums[mid]);
        midNode.left=build(nums,left,mid-1);
        midNode.right=build(nums,mid+1,right);
        return midNode;
    }
}
