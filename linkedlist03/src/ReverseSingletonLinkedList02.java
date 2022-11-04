/**
 * @author :zhangwensheng
 * @date : 2022/10/28  0028 20:33
 */
/*
* 模拟反转操作
* cur节点把next指向前,所以要pre指针的存在
* cur节点后要变成cur.next,所以提前存好Last节点
* */
public class ReverseSingletonLinkedList02 {
    public static class ListNode{
        int val;
        ListNode next;
    }

    // 快慢指针
    public ListNode reverseList(ListNode head) {
        ListNode pre=null;
        ListNode cur=head;
        ListNode last=null;
        while(cur!=null){
            // 先寄后面
            last=cur.next;
            // 反向改指针
            cur.next=pre;
            // 后期处理
            pre=cur;
            cur=last;
        }
        return pre;
    }

    // 递归
    public static ListNode reverseWithRecursion(ListNode head){
     // cur..先把cur.next后面一连串反转好;
     // cur.next.next=cur;
     // cur=null;
     if (head==null||head.next==null) return head;
     ListNode last = reverseWithRecursion(head.next);
     head.next.next=head;
     head.next=null;
     return last;
    }
}
