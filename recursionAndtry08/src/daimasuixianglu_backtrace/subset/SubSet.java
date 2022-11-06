package daimasuixianglu_backtrace.subset;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :zhangwensheng
 * @date : 2022/11/6  0006 10:48
 *
 * TODO:子集问题本质就是所有的组合数
 */
public class SubSet {
    public List<List<Integer>> subsets(int[] nums) {
        //子集问题再我的理解就是所有的组合数
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path=new ArrayList<>();
        process(nums,0,path,result);
        return result;
    }
    public void process(int[] nums,int index,List<Integer> path,List<List<Integer>> result){
        if(index==nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        path.add(nums[index]);
        process(nums,index+1,path,result);
        path.remove(path.size()-1);
        process(nums,index+1,path,result);
    }
}
