package daimasuixianglu.combine;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :zhangwensheng
 * @date : 2022/11/5  0005 16:32
 *
 */
public class Combine {
    /*
    * question:
    * 1~N的数，给定一个k，返回1~N的组合数，要求个数未k
    * */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> path=new ArrayList<>();
        process(n,k,1,result,path);
        return result;
    }

    public void  process(int n,int k,int index,List<List<Integer>> result,List<Integer> path){
        if(path.size()==k){
            result.add(new ArrayList<>(path));
            return;
        }
        if(index>n) return;
        path.add(index);
        process(n,k,index+1,result,path);
        path.remove(path.size()-1);
        process(n,k,index+1,result,path);
    }


}
