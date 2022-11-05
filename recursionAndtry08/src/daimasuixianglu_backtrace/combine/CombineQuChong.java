package daimasuixianglu_backtrace.combine;

import java.util.*;

/**
 * @author :zhangwensheng
 * @date : 2022/11/5  0005 22:03
 * TODO:组合去重:排序+for循环加入set标志
 *      PS:尽管for不能收集所有的最后为不要的元素的组合,但在base case中,满足了条件就会马上终止收集
 */
public class CombineQuChong {
    /*
    * 题目:一个数组,数组数每个元素只能出现一次,但是数组中有重复的元素
    * 求:找到这样的组合:组合数的累加为target,
    *    集合不能包含重复的元素:如[1,2,1][1,1,2]
    * 重复的原因:
    * 1:在一个位置,有两个元素一样的元素出现过了---hashset去跳过
    * 2:[1,7,1,5]这样的数组:[1,7][7,1]尽管层序跳过了1,但是7,1的时候,后面的1是作为第二层,导致重复---数组先排序,然7在1,后面,跳过了第二个1,7只能从数组后面选元素,深度遍历的时候不能选到1
    * */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> path= new ArrayList<>();
        Arrays.sort(candidates);
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


        //去重的时候,for模板(广度去重)+数组排序(深度去重)
        //不用担心for模板收集不到最 [后元素为不要]  的序列,因为base case在满足的时候,会直接收集return-------------后序感悟:for可以收集全部子序列,它不是在index==length收集:在程序开头就收集不要的情况下的,在for循环收集要的情况下的
        //非for模板不可去重:因为set是不共享的,因为调用不要的时候,开辟了下一层,下一层需要要...上一层的要和新开辟的要在for模板里是代表层序遍历,但是非for模板不在一层不能共享,所以不能去重
        Set<Integer> set=new HashSet<>();
        for(int i=index;i<candidates.length;i++){//i是层序,index是深度
            if(set.contains(candidates[i])) continue;
            set.add(candidates[i]);
            path.add(candidates[i]);
            process(candidates,i+1,target,result,path,sum+candidates[i]);
            path.remove(path.size()-1);
        }
    }
}
