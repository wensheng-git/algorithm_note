package daimasuixianglu_backtrace.permutation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :zhangwensheng
 * @date : 2022/11/6  0006 14:10
 * TODO:抓住一层可选择的容器reset就可以了
 */
public class Permutation {
    public List<List<Integer>> permute(int[] nums) {
        //第一层：可以选择每个nums
        //第二层，在nums-第一层的东西。建立一个容器表示还可以选择的nums
        // base case:path.size()==nums.length;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        List<Integer> reset = new ArrayList<>();
        for (int i : nums) reset.add(i);
        process(nums,reset,result,path);
        return result;
    }
    public void process(int[] nums,List<Integer> reset,List<List<Integer>> result,List<Integer> path){
        if(path.size()==nums.length){
            result.add(new ArrayList(path));
            return;
        }

        for (int i=0; i<reset.size(); i++){//这里是遍历reset的集合，所有从0开始
            int cur = reset.get(i);
            path.add(cur);
            reset.remove(i);
            process(nums,reset,result,path);
            path.remove(path.size()-1);
            reset.add(i,cur);
        }
    }
}
