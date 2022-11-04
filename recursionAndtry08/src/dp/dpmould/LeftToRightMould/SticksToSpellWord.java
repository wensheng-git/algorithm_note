package dp.dpmould.LeftToRightMould;

import java.util.HashMap;
import java.util.Map;

/**
 * @author :zhangwensheng
 * @date : 2022/11/4  0004 22:03
 */
public class SticksToSpellWord {
    /*
     * question
     * 给定一字符串str,一个支付串数组,现在从字符串数组中挑选若干个字符串,挑选出来的字符串可以随意剪切为单个字符
     * 可以挑选重复的无数张字符串,只要最后可以拼接为str就算成功
     * 问:最少需要多少张字符串卡片
     *
     * 尝试逻辑:
     * 从字符数组中挑选一个字符串,然后去改变str,若改变后的str还是之前的str一样,那么这张就是无效的
     * 无效那么就记录用了0张,然后去选下一个字符串;
     * 有效那么就记录+1张,然后去选下一个字符串
     * 如果需要拼接的字符串长度已经没有了,那么返回0张
     * */
    public static int process(String str, String[] sticks) {
        if (str.length() == 0) return 0;
        int min = Integer.MAX_VALUE;

        // 对于一层的参数,学会把后面的层当做一个黑盒,参数只对一层而言去分析
        for (String stick : sticks) {
            String reset = cut(str, stick);
            if (reset.length() != str.length()) {//有效我才继续选择去切了str后面时候需要的张数
                //对于第一张来说:剪切后可能str会面临不同的情况,我要去选择后面剪切最少的
                // 这里的min就是代表了后面拼接需要最少的张数
                min = Math.min(min, process(reset, sticks));
            }
            //无效则直接选择字符串数组的第二张去剪切
        }
        return min == Integer.MIN_VALUE ? min : min + 1;//加一就是代表本层选了一张,加上代表后面拼接需要最少的张数min
    }





    //可变参数是字符串,不可能转为为原原来的表结构
    //记忆化搜索
    public static int process_dp_cache(String str, String[] sticks, Map<String,Integer> map) {
        if (map.containsKey(str)) return map.get(str);
        if (str.length() == 0) map.put("",0);
        int min = Integer.MAX_VALUE;
        // 对于一层的参数,学会把后面的层当做一个黑盒,参数只对一层而言去分析
        for (String stick : sticks) {
            String reset = cut(str, stick);
            if (reset.length() != str.length()) {//有效我才继续选择去切了str后面时候需要的张数
                //对于第一张来说:剪切后可能str会面临不同的情况,我要去选择后面剪切最少的
                // 这里的min就是代表了后面拼接需要最少的张数
                min = Math.min(min, process(reset, sticks));
            }
            //无效则直接选择字符串数组的第二张去剪切
        }
        map.put(str, min == Integer.MIN_VALUE ? min : min + 1);//加一就是代表本层选了一张,加上代表后面拼接需要最少的张数min
        return map.get(str);
    }




    public static String cut(String str, String stick) {
        int[] count = new int[26];
        char[] s1 = str.toCharArray();
        char[] s2 = stick.toCharArray();
        for (char c : s1) {
            count[c - 'a']++;
        }
        for (char c : s2) {
            count[c - 'a']--;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count.length; i++) {
            while(count[i]-- > 0) {
                sb.append((char) (i + 'a'));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str="babac";
        String[] arr={"ba","c","abcd"};
        System.out.println(process(str, arr));
        System.out.println(process_dp_cache(str, arr, new HashMap<>()));
    }
}
