package movewindow;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :zhangwensheng
 * @date : 2022/10/30  0030 10:48
 *
 * 题目:
 * 给定两个字符串s和 p，找到s中所有p的异位词的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 *
 * TODO: 字符串涉及子串的问题---考虑滑动窗口(考察起始和终止指针)
 */
public class isAnagram_moveWinMould01 {
    public List<Integer> findAnagrams(String s, String p) {
        // 滑动窗口..先找到一样的长度,调用isAnagram,起始和终止指针一起动
        List<Integer> result=new ArrayList<>();
        int left=0;
        for (int right=0; right<s.length();right++){
            if((right-left+1)==p.length()){
                String sub=s.substring(left,right+1);
                boolean flag=isAnagram(sub,p);
                if (flag==true) result.add(left);
                left++;
            }
        }
        return result;
    }

    public boolean isAnagram(String sub,String p){
        int[] record=new int[26];
        for(int i=0;i<sub.length();i++)
            record[sub.charAt(i)-'a']++;
        for (int i=0;i<p.length();i++)
            record[p.charAt(i)-'a']--;
        for (int i=0;i<record.length;i++){
            if (record[i]!=0) return false;
        }
        return true;
    }
}
