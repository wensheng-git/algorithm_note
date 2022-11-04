package map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author :zhangwensheng
 * @date : 2022/10/30  0030 13:00
 *
 * 题目:
 * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
 * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N
 *
 * 思路:转化为两数相加的问题
 * 两数相加的问题就是先加入map中,再用遍历的时候查找map中有无target-nums[i]
 */
public class FourNumAdd_Map {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        // 四个数相加===>两数之和的问题
        // 两个数组各个两个元素相加情况放入map,key为相加值,value为出现的次数
        // 遍历另外两个数组,target-mapKey然后统计次数
        int result=0;
        Map<Integer ,Integer> map=new HashMap<>();
        for (int i:nums1){
            for (int j:nums2){
                if(map.containsKey(i+j)){
                    map.put(i+j,map.get(i+j)+1);
                }else{
                    map.put(i+j,1);
                }
            }
        }

        for (int i:nums3){
            for(int j:nums4){
                int k=0-(i+j);
                if(map.containsKey(k)) result+=map.get(k);
            }
        }

        return result;
    }
}
