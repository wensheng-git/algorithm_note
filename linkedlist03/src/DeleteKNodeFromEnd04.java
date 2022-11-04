/**
 * @author :zhangwensheng
 * @date : 2022/10/29  0029 0:41
 */
public class DeleteKNodeFromEnd04 {
    public static class ListNode{
        int val;
        ListNode next;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy=new ListNode();
        dummy.next=head;
        ListNode fast=dummy;
        ListNode slow=dummy;
        while(n-->0){
            fast=fast.next;
        }
        ListNode pre=null;
        while(fast!=null){
            pre=slow;
            slow=slow.next;
            fast=fast.next;
        }
        pre.next=pre.next.next;
        // 特别注意,有虚节点不仅仅可以忽略头部讨论,返回时候要返回dummy.next,因为head可能被改过
        return dummy.next;
    }
}
