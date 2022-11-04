package basicKnowledge.serilizeAndconstructTree;

import javax.swing.tree.TreeNode;
import java.util.HashMap;
import java.util.Map;

/**
 * @author :zhangwensheng
 * @date : 2022/11/3  0003 11:01
 * TODO:思路:
 *      确定一个根(一般用先序后者后序的元素去确定中序的位置[中序可以放到一个map中快速确定])
 *      然后根据中序遍历确定子数组长度,然后切割再去重新递归子数组
 */
public class InorderAndPostorderToBuildTree {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val=val;
        }
    }
    Map<Integer,Integer> map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        //后序和中序找根,切割数组递归
        map=new HashMap<>();//快速找到中序数组中的位置
        for (int i=0; i<inorder.length; i++){
            map.put(inorder[i],i);
        }
        return find(inorder,0,inorder.length-1,postorder,0,postorder.length-1);

    }
    public TreeNode find(int[] inorder,int inBegin,int inEnd,int[] postorder, int postBegin, int postEnd){
        if(inBegin>inEnd||postBegin>postEnd) return null;//想象两个元素的时候左是大于有右边的
        if(inBegin==inEnd || postBegin==postEnd) return new TreeNode(postorder[postEnd]);
        TreeNode root=new TreeNode(postorder[postEnd]);
        int rootIndex=map.get(root.val);
        int leftLen=rootIndex-inBegin;//左数组的长度,rootIndex不包括
        root.left=find(inorder,inBegin,inBegin+leftLen-1,postorder,postBegin,postBegin+leftLen-1);
        root.right=find(inorder,inBegin+leftLen+1,inEnd,postorder,postBegin+leftLen,postEnd-1);
        return root;
    }
}
