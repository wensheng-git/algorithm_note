package daimasuixianglu_backtrace;

import java.util.*;

/**
 * @author :zhangwensheng
 * @date : 2022/11/6  0006 13:45
 *
 *
 */
public class FindSubSequenceIncremental {
    public List<List<Integer>> findSubsequences(int[] nums) {
        //要去重【6，7，7】会收集两个【6，7】
        //base case  path.size>=2&&path里面递增的
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        process(nums,0,result,path);
        return result;
    }
    public void process(int[] nums,int index,List<List<Integer>> result,List<Integer> path){
        if(path.size()>=2){
            for(int i=1;i<path.size();i++){
                if(path.get(i)<path.get(i-1)) return;
            }
            result.add(new ArrayList(path));
            //不要return，不然只会收集2的，大于的都被cut了
        }
        if(index==nums.length) return;
        Set<Integer> set = new HashSet<>();//不用排序，我只是考虑层序需要去重，深度就算一样，我收集的是递增的，重复的会被cut掉
        for (int i=index; i<nums.length; i++){
            if(set.contains(nums[i])) continue;
            set.add(nums[i]);
            path.add(nums[i]);
            process(nums,i+1,result,path);
            path.remove(path.size()-1);
        }
    }


}
