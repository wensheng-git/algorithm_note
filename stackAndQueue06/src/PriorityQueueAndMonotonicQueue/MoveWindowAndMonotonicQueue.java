package PriorityQueueAndMonotonicQueue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author :zhangwensheng
 * @date : 2022/10/31  0031 20:57
 *  // 单调队列:在区间联系了某种单调性,最大最小值等等
 *  // 本题:滑动窗口上求最大值(单调性)
 *  // 单调队列本质:它存储数组元素的下标,维护了一组成为最大值的优先级队列
 *  // left++要看队列的peek是不是在left的左边,在就弹出
 *  // right++看队列peekLast对应的元素小于了本元素,小于循环弹
 *  TODO:队列加入的是下标而不是元素!!!!!!!!!!
 */
public class MoveWindowAndMonotonicQueue {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int[] result=new int[nums.length-k+1];
        int m=0;
        //双端队列
        Deque<Integer> que=new ArrayDeque<>();
        for (int i=0;i<nums.length;i++){ //i为右指针
            //left=i-k+1;(所以left移动,如果que.peek在left的左边就是过期了)
            if(!que.isEmpty()&&que.peek()<i-k+1)
                que.poll();
            //right=i,加入对尾巴的时候,比我小的我统统干掉
            while(!que.isEmpty()&&nums[que.peekLast()]<nums[i])
                que.pollLast();
            que.add(i);

            //搜集
            if(i+1>=k) result[m++]=nums[que.peek()];
        }
        return result;
    }
}
