package daimasuixianglu_backtrace.combine;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :zhangwensheng
 * @date : 2022/11/5  0005 19:47
 */
public class CombineSum {
    /*
    * question:
    * 1~9的数组中,选择k的组合数,这些数的累加和是n,返回符合的所有的组合数
    * */
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> path=new ArrayList<>();
        process(k,n,1,result,path);
        return result;
    }

    public void process(int k, int n, int index, List<List<Integer>> result, List<Integer> path){
        //TODO:组合问题中筛选的东西(千变万化在此)
        if(path.size()==k){//在k个组合数中再次筛选
            int sum=0;
            for(int i : path){
                sum+=i;
            }
            if(sum==n) result.add(new ArrayList<>(path));
            return;
        }
        if(index>9) return;//没有收集到(这个要写在收集的后面,收集最后一个后,index+1了,但是path里面的只有index,所以先要去看有无收集好)

        //TODO:组合问题[子序列问题必备套路]
        //要
        path.add(index);
        process(k,n,index+1,result,path);
        //不要
        path.remove(path.size()-1);
        process(k,n,index+1,result,path);
    }
}
