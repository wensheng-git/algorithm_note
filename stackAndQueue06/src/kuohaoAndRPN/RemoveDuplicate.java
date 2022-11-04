package kuohaoAndRPN;

import java.util.Stack;

/**
 * @author :zhangwensheng
 * @date : 2022/10/31  0031 11:43
 * 题目:
 * 给定一个字符串,只要字符串有响铃的相同的元素都把他删除,返回新的字符串
 * TODO:栈的应用只要是遍历的时候需要和前面的元素比较的东西都可以用栈
 */
public class RemoveDuplicate {
    public String removeDuplicates(String s) {
        // 边加入栈边peek顶元素
        Stack<Character> stack=new Stack<>();
        char[] chars=s.toCharArray();
        for(char i:chars){
            if(stack.isEmpty()||stack.peek()!=i)
                stack.push(i);
            else stack.pop();
        }
        char[] ch=new char[stack.size()];
        for (int i=ch.length-1;i>=0;i--) ch[i]=stack.pop();
        return new String(ch);
    }
}
