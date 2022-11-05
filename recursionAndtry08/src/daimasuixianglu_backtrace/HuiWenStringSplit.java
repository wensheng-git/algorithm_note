package daimasuixianglu_backtrace;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :zhangwensheng
 * @date : 2022/11/6  0006 1:16
 */
public class HuiWenStringSplit {
    public List<List<String>> partition(String s) {
        //回溯思想:先思考层序(第一刀的可能),传递层序的起点+1到下一层
        //第一刀的可能性(层序遍历):从0开始切.子串(0,0)(0,1)(0,N);
        //第二刀第三到...(深度遍历):从1开始切,子串(1,1)(1,2)(1,N)
        //base case:第n刀开始切的时候,是从str.length()开始切.证明已经切割完成了

        List<List<String>> result=new ArrayList<>();
        List<String> path=new ArrayList<>();
        process(s,0,path,result);
        return result;
    }
    public void process(String s,int index,List<String> path,List<List<String>> result){
        if(index==s.length()){
            result.add(new ArrayList(path));
            return;
        }
        for (int i=index;i<s.length();i++){
            String str = s.substring(index,i+1);//前开后闭
            if(!isHuiwen(str)) continue;//本次剪切无效..层序遍历去看这一刀的其他切法
            path.add(str);
            process(s,i+1,path,result);//下一刀从第一刀的结束开始切
            path.remove(path.size()-1);//回溯,本层的其他切法
        }
    }
    public boolean isHuiwen(String s){
        int start=0;
        int end=s.length()-1;
        while(start<end){
            if(s.charAt(start++)!=s.charAt(end--)) return false;
        }
        return true;
    }
}
