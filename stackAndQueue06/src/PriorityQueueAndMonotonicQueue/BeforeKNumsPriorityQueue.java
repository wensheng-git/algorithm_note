package PriorityQueueAndMonotonicQueue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author :zhangwensheng
 * @date : 2022/10/31  0031 21:18
 *
 * 返回数组出现次数前K高的元素
 * 先搜集频率
 * 根据频率排序(优先队列,可以指定排序规则)
 *
 * TODO:compare(o1,o2);升序o1-o2  降序:o2-o1
 */
public class BeforeKNumsPriorityQueue {
    public int[] topKFrequent(int[] nums, int k) {
        // 先统计频率
        // 装入大根堆中,指定降序排序
        // 收集k个
        Map<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])) map.put(nums[i],map.get(nums[i])+1);
            else map.put(nums[i],1);
        }
        //指定优先队列O(1)的操作
        PriorityQueue<int[]> que=new PriorityQueue<>((o1, o2)->o2[1]-o1[1]);
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            que.add(new int[]{entry.getKey(),entry.getValue()});
        }

        int[] result=new int[k];
        int i=0;
        while(k-->0) result[i++]=que.poll()[0];
        return result;
    }
}
