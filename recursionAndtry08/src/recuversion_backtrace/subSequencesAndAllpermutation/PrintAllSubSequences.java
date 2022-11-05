package recuversion_backtrace.subSequencesAndAllpermutation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author :zhangwensheng
 * @date : 2022/11/3  0003 22:08
 *
 * 什么是子序列 ?
 * 任意拿,不用规定顺序
 * 什么是子串 ?
 * 任意截取连续的序列
 *
 * TODO:拓展：去重的子序列：因为给定的数组有重复值，那么直接用set装子序列就可以去重
 */
public class PrintAllSubSequences {
    /*
    * str:字符串
    * index：来到的位置
    * path: 我收集的一个子序列
    * ans：存放子序列
    * */
    //更好理解.更简单(去重的时候需要借助)
    public static void process(char[] str, int index, String path, List<String> ans){
        if (index==str.length){
            ans.add(path);
            return;
        }
        //逻辑，我要和不要
        String no=path;
        process(str,index+1,no,ans);
        String yes=path+str[index];
        process(str,index+1,yes,ans);
    }

    //这里是index后面所有的元素依次来试我这个位置...更具有变化性
    public static void process2(char[] str, int index, String path, List<String> ans){
        //这里直接先收集.....而不是等于length再收集[即先收集不要的情况,要的时候调用了index+1,让下一层去收集上一层的结果]
        ans.add(path);
        if (index==str.length){
            return;
        }
        //逻辑，我要和不要
        for (int i=index;i<str.length;i++){
            process2(str,i+1,path+str[i],ans);
        }
    }

    public static void main(String[] args) {
        String s="1234";
        char[] str = s.toCharArray();
        String path="";
        List<String> list = new ArrayList<>();
        process(str,0,path,list);
        for (String str1:list){
            System.out.println(str1);
        }
        System.out.println("================");
        list.clear();
        path="";
        process2(str,0,path,list);
        for (String str1:list){
            System.out.println(str1);
        }
    }
}
