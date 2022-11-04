/**
 * @author :zhangwensheng
 * @date : 2022/10/29  0029 9:57
 */
public class IntersectionNode05 {
    public static class ListNode{
        int val;
        ListNode next;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA=0;
        int lenB=0;
        ListNode cur=headA;
        while(cur!=null){
            lenA++;
            cur=cur.next;
        }
        cur=headB;
        while(cur!=null){
            lenB++;
            cur=cur.next;
        }
        int count=Math.abs(lenA-lenB);
        ListNode headMax=lenA>lenB?headA:headB;
        ListNode headMin=lenA>lenB?headB:headA;
        while(count-->0){
            headMax=headMax.next;
        }
        while(headMax!=null){
            if(headMax==headMin) return headMax;
            headMax=headMax.next;
            headMin=headMin.next;
        }
        return null;
    }
}
