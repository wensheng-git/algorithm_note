package set;

import java.util.HashSet;
import java.util.Set;

/**
 * @author :zhangwensheng
 * @date : 2022/10/30  0030 11:11
 *
 * 题目:
 * 题意：给定两个数组，编写一个函数来计算它们的交集。
 * TODO:一般hash先考虑set其次后面的map&array
 */
public class ArrayIntersection_SetMould01 {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1==null||nums2==null||nums1.length==0||nums2.length==0)
            return new int[0];

        Set<Integer> set=new HashSet<>();
        Set<Integer> setRes=new HashSet<>();
        for (int i=0;i<nums1.length;i++)
            set.add(nums1[i]);
        for (int i=0;i<nums2.length;i++){
            if(set.contains(nums2[i]))  setRes.add(nums2[i]);
        }
        int[] result=new int[setRes.size()];
        int k=0;
        for(Integer i:setRes){
            result[k++]=i;
        }
        return result;
    }
}
