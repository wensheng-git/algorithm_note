package doublePointer;

/**
 * @author :zhangwensheng
 * @date : 2022/10/30  0030 20:49
 *
 * TODO:其实很多数组填充类的问题，都可以先预先给数组扩容带填充后的大小，然后在从后向前进行操作。
 */
public class ReplaceSpace_doublePointer {
    public String replaceSpace(String s) {
        //1简单做法是申请一个StringBuilder然后一个一个append,空格特殊
        //TODO:2极致做法DoubePointer(快慢指针),先把原string加到扩容后的长度
        //      然后left指针从之前的长度开始,right指针从现在的长度开始向前遍历,right是不可能超过left的,
        //      正因为扩容是在后面添加的,要让right不可能超过left,只能向前遍历填充
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<s.length();i++){
            if(s.charAt(i)==' ') sb.append("  ");
        }

        int left=s.length()-1;
        s+=sb.toString();
        int right=s.length()-1;
        // 没有空格
        if(left==right) return s;
        // charAt方法是不能设置值的
        char[] chars=s.toCharArray();
        while(left>=0){
            if(chars[left]==' '){
                chars[right]='0';
                chars[--right]='2';
                chars[--right]='%';
            }else{
                chars[right]=chars[left];
            }
            right--;
            left--;
        }
        return new String(chars);
    }
}
