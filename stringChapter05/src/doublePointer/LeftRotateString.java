package doublePointer;

/**
 * @author :zhangwensheng
 * @date : 2022/10/30  0030 21:58
 *
 *
 * 题目:
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 * TODO:只要涉及字符串转来转去的就往反转字符串想---千变万化
 */
public class LeftRotateString {
    public String reverseLeftWords(String s, int n) {
        char[] chars=s.toCharArray();
        reverse(chars,0,chars.length-1);
        reverse(chars,0,chars.length-n-1);
        reverse(chars,chars.length-n,chars.length-1);
        return new String(chars);
    }

    public void reverse(char[] chars,int left,int right){
        while(left<right){
            char temp=chars[left];
            chars[left]=chars[right];
            chars[right]=temp;
            left++;
            right--;
        }
    }
}
