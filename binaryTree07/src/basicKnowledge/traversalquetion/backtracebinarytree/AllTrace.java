package basicKnowledge.traversalquetion.backtracebinarytree;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * @author :zhangwensheng
 * @date : 2022/11/2  0002 20:45
 */
public class AllTrace {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val=val;
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result=new ArrayList<>();
        List<Integer> path=new ArrayList<>();
        process(root,result,path);
        return result;
    }
    // 递归带着回溯
    //参数类型
    public void process(TreeNode root,List<String> list,List<Integer> path){
        path.add(root.val);
        //终止条件
        if(root.left==null&&root.right==null){
            StringBuilder s=new StringBuilder(String.valueOf(path.get(0)));
            for (int i=1;i<path.size();i++){
                s.append("->"+path.get(i));
            }
            list.add(s.toString());
            return;
        }
        //一层逻辑
        if(root.left!=null) {
            process(root.left,list,path);
            path.remove(path.size()-1);//回溯在此
        }
        if(root.right!=null) {
            process(root.right,list,path);
            path.remove(path.size()-1);
        }
    }
}
