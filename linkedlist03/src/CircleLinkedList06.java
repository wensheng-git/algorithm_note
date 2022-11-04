/**
 * @author :zhangwensheng
 * @date : 2022/10/29  0029 9:58
 */
/*
* 奥数问题:
* fast和slow在环里必相遇
* 相遇点到环口的距离是起点到环口的距离-----由于slow*2=fast变化得出
* */
public class CircleLinkedList06 {
    public static void main(String[] args) {
    }
    public static class ListNode{
        int val;
        ListNode next;
    }
    // 用容器set装一个链表,然后迭代另一个链表,时间也是O(n)...笔试使用
    public ListNode detectCycle(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(slow==fast){
                fast=head;
                while(fast!=slow){
                    fast=fast.next;
                    slow=slow.next;
                }
                return fast;
            }
        }
        return null;
    }
}
