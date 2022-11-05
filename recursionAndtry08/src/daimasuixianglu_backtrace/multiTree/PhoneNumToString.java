package daimasuixianglu_backtrace.multiTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :zhangwensheng
 * @date : 2022/11/5  0005 20:33
 */
public class PhoneNumToString {
    /*
    * TODO:多叉树的递归回溯套路
    * 题目:
    * 手机里面的九建对应着不同的字母,由2~9里面的任意数字拼接的字符串,返回可以转化的字符串
    * 画图:多叉树
    * 三步核心逻辑:
    *           for一层:找到一层可以选择的容器
    *           递归时候:找到下一层index控制
    *           回溯为了层序遍历
    * */

    public List<String> letterCombinations(String digits) {
        //画图:多叉树使用一次遍历一层回溯并且递归去下一层去处理
        //每层可以选择对应的数字所能转化的字母(一层for)(回溯决定用哪个)
        //第二层我们要用index+1对应的数字编号,,也可以转化为一系列的字母

        //索引对应数字,值对应编码
        String[] map={"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<Character> path = new ArrayList<>();
        List<String> result=new ArrayList<>();
        if(digits==null||digits.length()==0)
            return result;
        process(digits,0,map,path,result);
        return result;
    }
    public void process(String digits,int index, String[] map, List<Character> path, List<String> result){
        if(index==digits.length()){
            StringBuilder sb=new StringBuilder();
            for (char c : path){
                sb.append(c);
            }
            result.add(sb.toString());
            return;
        }

        String str=map[digits.charAt(index)-'0'];//一层要遍历的
        for (int i=0;i<str.length();i++){//层的遍历
            path.add(str.charAt(i));
            process(digits,index+1,map,path,result);//深度遍历(下一个数字)
            path.remove(path.size()-1);//回溯然后层的继续遍历
        }
    }
}
