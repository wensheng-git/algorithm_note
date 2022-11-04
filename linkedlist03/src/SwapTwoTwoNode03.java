/**
 * @author :zhangwensheng
 * @date : 2022/10/29  0029 0:23
 */
public class SwapTwoTwoNode03 {
    public static class ListNode{
        int val;
        ListNode next;
    }
    public ListNode swapPairs(ListNode head) {
        // 两个,两个一个单位,借助三指针,pre在前两个的前面(借助哑元[头部不用分类讨论])
        if(head==null||head.next==null) return head;
        ListNode dummy=new ListNode();
        ListNode pre=dummy;
        pre.next=head;
        ListNode cur=head;
        ListNode last=cur.next;
        while(cur!=null&&last!=null){ // 只有一个不用反转
            pre.next=last;
            cur.next=last.next;
            last.next=cur;
            pre=cur;
            cur=cur.next;
            if(cur!=null) last=cur.next;
        }

        return dummy.next;
    }
}
