package daimasuixianglu.combine;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :zhangwensheng
 * @date : 2022/11/5  0005 21:29
 *
 * TODO:重复元素使用的组合在:index位置要的时候,下一层依旧是index
 *      在base case中,因为要的东西的累加到一个界限去终止它.防止爆栈
 */
public class CombineUseRepeatElement {
    /*
    * 题目:
    * 一个数组中,任意组合,要求组合等于target值,返回可以的组合类型
    * PS:这里的组合是可以重复使用一个元素的
    * */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> path= new ArrayList<>();
        process(candidates,0,target,result,path,0);
        return result;
    }
    public void process(int[] candidates,int index,int target,List<List<Integer>> result,List<Integer> path,int sum){
        if(sum>target) return;
        if(sum==target){
            result.add(new ArrayList(path));
            return;
        }
        if(index==candidates.length) return;



        //**TODO:固定模板在要的时候,选择重复要该位置,在base case 有条件终止
        path.add(candidates[index]);
        //这里可以用index..表示下一层依然用本元素...下一层当然可以无限使用(base case不会让它无限递归),不用的时候可以选择下面的index+1
        process(candidates,index,target,result,path,sum+candidates[index]);
        path.remove(path.size()-1);
        process(candidates,index+1,target,result,path,sum);//不能再次重复不要,一直重复不要sum不会加,会爆了栈
    }
}
