/**
 * @author :zhangwensheng
 * @date : 2022/10/28  0028 20:07
 */
/*
* 题目:
* 给定一个链表和一个数val,要求把节点都是val的删除并且返回链表
* */
public class RemoveVal01 {
    public static class ListNode{
        int val;
        ListNode next;
        public ListNode(){};
    }
    public ListNode removeElements(ListNode head, int val) {
        // 不设置dummy虚节点在于要单独讨论头结点问题:会比较麻烦,所以都设置虚节点吧,除了反转链表
        ListNode dummy=new ListNode();
        ListNode cur=head;
        ListNode pre=dummy;
        dummy.next=head;
        while(cur!=null){
            if(cur.val==val) pre.next=cur.next;
            else pre=cur;
            cur=cur.next;
        }
        return dummy.next;
    }
}
