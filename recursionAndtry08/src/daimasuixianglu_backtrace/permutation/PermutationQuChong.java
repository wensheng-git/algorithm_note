package daimasuixianglu_backtrace.permutation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author :zhangwensheng
 * @date : 2022/11/6  0006 14:17
 */
public class PermutationQuChong {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        List<Integer> reset = new ArrayList<>();
        for (int i : nums) reset.add(i);
        process(nums,reset,result,path);
        return result;
    }
    public void process(int[] nums,List<Integer> reset,List<List<Integer>> result,List<Integer> path) {
        if (path.size() == nums.length) {
            result.add(new ArrayList(path));
            return;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < reset.size(); i++) {//这里是遍历reset的集合，所有从0开始
            if (set.contains(reset.get(i))) continue;
            set.add(reset.get(i));
            int cur = reset.get(i);
            path.add(cur);
            reset.remove(i);
            process(nums, reset, result, path);
            path.remove(path.size() - 1);
            reset.add(i, cur);
        }
    }
}
