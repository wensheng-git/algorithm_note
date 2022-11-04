package doublePointer;

/**
 * @author :zhangwensheng
 * @date : 2022/10/30  0030 21:21
 */
/*
* TODO:只要反转字符串:双向指针就是核心逻辑,剩下的都是千变万化
* */
public class ReverseSentence {
    public String reverseWords(String s) {
        String str=removeSpace(s);
        char[] ch=str.toCharArray();
        reverse(ch,0,ch.length-1);
        for(int left=0;left<ch.length;){
            int right=left+1;
            while(right<ch.length&&ch[right]!=' ') right++;
            reverse(ch,left,right-1);
            left=right+1;
        }
        return new String(ch);
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

    public String removeSpace(String s){
        StringBuilder sb=new StringBuilder();
        //首尾去了
        int start=0,end=s.length()-1;
        while(s.charAt(start)==' ') start++;
        while(s.charAt(end)==' ') end--;

        while(start<=end){
            if(s.charAt(start)==' '&&s.charAt(start-1)==' ') { start++;continue;}
            sb.append(s.charAt(start++));
        }
        return new String(sb);
    }
}
