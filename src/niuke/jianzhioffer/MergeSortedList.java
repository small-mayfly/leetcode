package niuke.jianzhioffer;

public class MergeSortedList {

    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1==null)
            return list2;
        else if(list2==null)
            return list1;
        else{
            ListNode rhead = new ListNode(-1);
            ListNode t = rhead;
            while (list1!=null && list2!=null){
                if(list1.val<list2.val){
                    t.next = list1;
                    list1 = list1.next;
                }else{
                    t.next = list2;
                    list2 = list2.next;

                }
                t = t.next;
            }
            if(list1==null){
                t.next = list2;
            }else{
                t.next = list1;
            }
            return rhead.next;
        }


    }

    public static void main(String[] args) {

    }
}
