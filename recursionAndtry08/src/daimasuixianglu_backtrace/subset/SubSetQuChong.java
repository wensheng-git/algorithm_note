package daimasuixianglu_backtrace.subset;

import java.util.*;

/**
 * @author :zhangwensheng
 * @date : 2022/11/6  0006 11:30
 *
 * TODO：子集去重和组合去重一样.....................排序+for模板
 */
public class SubSetQuChong {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        //去重子集和去重组合数一样
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(nums);
        process(nums,0,result,path);
        return result;
    }

    public void process(int[] nums,int index,List<List<Integer>> result,List<Integer> path){
        result.add(new ArrayList(path));
        if(index==nums.length) return;
        Set<Integer> set = new HashSet<>();
        for(int i=index; i<nums.length; i++){
            if(set.contains(nums[i])) continue;
            set.add(nums[i]);
            path.add(nums[i]);
            process(nums,i+1,result,path);
            path.remove(path.size()-1);
        }
    }
}
