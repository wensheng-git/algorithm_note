import java.util.ArrayList;
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
    //类似这种全遍历的每个元素可以画树状图去理解
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
    public static void main(String[] args) {
        String s="abc";
        char[] str = s.toCharArray();
        String path="";
        List<String> list = new ArrayList<>();
        process(str,0,path,list);
        for (String str1:list){
            System.out.println(str1);
        }
    }
}
