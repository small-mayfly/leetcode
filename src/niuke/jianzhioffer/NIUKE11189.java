package niuke.jianzhioffer;

/**
 * 输入两个链表，找出它们的第一个公共结点。
 * 根据题意可以推测，公共节点之后的所有点应该是由两个链表共用
 * 所以只需要先让比较长的链表向后移动，使得两个链表一样长，之后依次向后遍历即可
 */
public class NIUKE11189 {

    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int l1Len = 0;
        int l2Len = 0;
        ListNode temp;
        temp = pHead1;
        while (temp!=null){
            l1Len++;
            temp = temp.next;
        }
        temp = pHead2;
        while (temp!=null){
            l2Len++;
            temp = temp.next;
        }
        ListNode temp2;
        temp = pHead1;
        temp2 = pHead2;
        if(l1Len>l2Len){
            while (l1Len>l2Len){
                temp=temp.next;
                l1Len--;
            }
        }else {
            while (l2Len>l1Len){
                temp2=temp2.next;
                l2Len--;
            }
        }
        while (temp!=temp2){
            temp=temp.next;
            temp2=temp2.next;
        }

        return temp;
    }

}
