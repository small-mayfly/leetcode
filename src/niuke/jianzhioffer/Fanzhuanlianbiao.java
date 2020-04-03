package niuke.jianzhioffer;

public class Fanzhuanlianbiao {
    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode ReverseList(ListNode head) {
        if(head==null)
            return null;
        ListNode rhead = new ListNode(-1);
        rhead.next = head;

        ListNode rem = head;
        ListNode t;
        while(rem.next!=null){
            t = rem.next;
            rem.next = t.next;
            t.next = rhead.next;
            rhead.next = t;

        }
        return rhead.next;
    }

    public static void main(String[] args) {

    }



}
