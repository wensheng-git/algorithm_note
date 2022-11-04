package kuohaoAndRPN;

import java.util.Stack;

/**
 * @author :zhangwensheng
 * @date : 2022/10/31  0031 10:43
 * 题目:
 * 给出一系列的括号,类似这种为合法有效({{[]}),否者无效
 */
public class isValidKuoHao {
    class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack=new Stack<>();
            for (int i=0;i<s.length();i++){
                if(s.charAt(i)=='('||s.charAt(i)=='{'||s.charAt(i)=='[')
                    stack.push(s.charAt(i));
                // 注意:这里必须是保证stack不能为空,否者就是不匹配直接报错
                else if(s.charAt(i)==')'&&!stack.isEmpty()&&stack.peek()=='(') stack.pop();
                else if(s.charAt(i)=='}'&&!stack.isEmpty()&&stack.peek()=='{') stack.pop();
                else if(s.charAt(i)==']'&&!stack.isEmpty()&&stack.peek()=='[') stack.pop();
                else return false;
            }
            return stack.isEmpty();
        }
    }
}
