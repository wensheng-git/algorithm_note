package moveWindow;

import java.util.HashSet;
import java.util.Set;

/**
 * @author :zhangwensheng
 * @date : 2022/10/28  0028 15:02
 */
public class MaxFruits {
    public static int totalFruit(int[] fruits) {
        // 每个窗口必须只有两种数字,返回最大的窗口
        int left=0;
        int max=Integer.MIN_VALUE;
        Set<Integer> set=new HashSet<>();
        for(int right=0;right<fruits.length;right++){
            if(set.size()<2||(set.size()==2&&set.contains(fruits[right]))){
                set.add(fruits[right]);
            }else{ //出现了第三种元素
                set.add(fruits[right]);
                // **调节起始位置,left必须踩到right-1的一样的元素且踩到后,left和right-1不能有其他元素
                int temp=fruits[right-1];
                int i=2;
                while(fruits[right-i]==temp) i++;
                set.remove(fruits[right-i]);
                while(left<=right-i) left++;
            }
            max=Math.max(right-left+1,max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] fruits={3,3,3,1,2,1,1,2,3,3,4};
        System.out.println(totalFruit(fruits));
    }
}
