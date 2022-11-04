package array;

/**
 * @author :zhangwensheng
 * @date : 2022/10/29  0029 15:24
 */
/*
* 题目:
* 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
* 注意：s 和 t中每个字符出现的次数都相同，则称s和t互为字母异位词。
* TODO:
*  数组做hash:用元素加工成ASCII码作为索引....
*  适用:(一般适用于元素已经固定了的东西)
*  注意:数组是一种特殊的map,index=>key value=>value;
* TODO:
*   思路hash:先考虑set,去重即可
*           在考虑map或者数组
* */
public class IsAnagram_ArrayMould01 {
    public static void main(String[] args) {
        StringBuilder gds = new StringBuilder("gds");
        String s="jkslj";
        s+=gds;
        System.out.println(s);
    }
    public boolean isAnagram(String s, String t) {
        // 数组作为hash
        // record[s[i]-a] 用元素加工作为hash的下标
        // 遍历两个字符串,来统计s,t的,一个++,一个--;最后看数组是不是都是0
        int[] record=new int[26];
        for (int i=0;i<s.length();i++)
            record[s.charAt(i)-'a']++;
        for (int i=0;i<t.length();i++)
            record[t.charAt(i)-'a']--;

        for (int i=0;i<record.length;i++){
            if(record[i]!=0) return false;
        }
        return true;
    }
}
