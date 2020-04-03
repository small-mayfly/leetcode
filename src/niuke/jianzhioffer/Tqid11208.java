package niuke.jianzhioffer;

/**
 * 假设从出发点到环入口长度为a
 * 环入口到相遇点长度为b
 * 相遇点到环入口长度为c
 * 因为快指针速度为慢指针速度的2倍，所以2(a+b)=a+b+c+b
 * 所以a=c
 * 所以找到相遇点后，只需要从开头和相遇点同时向后走，两个指针相遇的点即为环入口结点
 */
public class Tqid11208 {

    class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode findOneNode(ListNode head){

        ListNode t1 = head.next;
        ListNode t2 = head.next;
        if(t2==null)
            return null;
        t2 = t2.next;

        while (t2 != t1){
            t1 = t1.next;
            t2 = t2.next;
            if(t2==null)
                return null;
            t2 = t2.next;
        }
        return t1;
    }

    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        // 找到快慢指针相遇点
        ListNode meet = findOneNode(pHead);
        // 从头和相遇点同时出发向后遍历，找到环入口点
        if(meet==null)
            return null;
        ListNode head = pHead;
        while (head!=meet){
            head = head.next;
            meet = meet.next;
        }
        return head;
    }



}
