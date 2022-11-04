package map;

import java.util.*;

/**
 * @author :zhangwensheng
 * @date : 2022/10/30  0030 9:58
 */
/*
* 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
* 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
*
* TODO:返回值数据比较多,要借助map
* */
public class isAnagram_MapMould01{
    public List<List<String>> groupAnagrams(String[] strs) {
        // 涉及到异位词和数组(多维度变化==>map)
        // key是排序好的str,value是一个数组,再用一个list把这些数组装起来
        Map<String,List<String>> map=new HashMap<>();
        List<List<String>> result=new ArrayList<>();
        for (String str:strs){
            char[] chars=str.toCharArray();
            Arrays.sort(chars);
            String sortStr=new String(chars); // 以后的toString尽量用new String(太多的类没有重写tosString方法)
            if(!map.containsKey(sortStr)){
                List<String> list=new ArrayList<>();
                map.put(sortStr,list);
                list.add(str);
                result.add(list);
            }else{
                List<String> list= map.get(sortStr);
                list.add(str);
            }
            // jdk8添加的方法:先get/get不到就default设置--(key,default)
            // List<String> list=map.getOrDefault(sortStr,new ArrayList<String>());
            // list.add(str);
            // map.put(sortStr,list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
