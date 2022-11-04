package kuohaoAndRPN;

import java.util.Stack;

/**
 * @author :zhangwensheng
 * @date : 2022/10/31  0031 11:48
 *
 * 题目:TODO:逆波兰表达式....经典栈的应用的题目
 * 根据 逆波兰表示法，求表达式的值。
 * 有效的运算符包括 + ,  - ,  * ,  / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 *
 * TODO:中缀转后缀表达式==>
 * (a+b)===>ab+----ab可以是数字也可以是一个后缀表达式
 * 如:(((1+(3*2))-2)/2)
 * 每一个运算符都要加括号
 * ===>(((1+*32)-2)/2)===>((132*+-2)/2)==>(132*+2-/2)===>132*+2-2/
 * TODO:计算
 *  遍历后缀表达式:
 *  遇到数字直接入栈
 *  遇到运算符弹出两个(第一弹为运算符右数,第二弹为左数,计算后压入)
 */
public class ReversePolishNotation {
    public int evalRPN(String[] tokens) {
        // TODO:PS:比较字符串需要用equals而不是==
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<tokens.length;i++){
            if(tokens[i].equals("+")){
                stack.push(stack.pop()+stack.pop());
            }
            else if(tokens[i].equals("-")){
                int right=stack.pop();
                int left=stack.pop();
                stack.push(left-right);
            }
            else if(tokens[i].equals("*")){
                stack.push(stack.pop()*stack.pop());
            }
            else if(tokens[i].equals("/")){
                int right=stack.pop();
                int left=stack.pop();
                stack.push(left/right);
            }
            else { stack.push(Integer.valueOf(tokens[i]));
            }
        }
        return stack.pop();
    }
}
   