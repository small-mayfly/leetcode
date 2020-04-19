package medium;

public class AddTwoNumbersii {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public int magic(ListNode l1, ListNode l2){
        int last = 0;
        if(l1.next!=null){
            last = magic(l1.next, l2.next);
        }
        int t = l1.val + l2.val + last;
        l1.val = t%10;
        return t/10;
    }

    public int magic2(ListNode l1, ListNode l2, int index, int more){
        int last = 0;
        if(index<more){
            last = magic2(l1.next, l2, index+1, more);
            int t = l1.val + last;

            l1.val = t%10;

            return t/10;
        }else{
            last = magic(l1, l2);
            return last;
        }


    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1 = 0;
        int len2 = 0;
        ListNode t = l1;
        while (t!=null){
            t=t.next;
            len1++;
        }
        t = l2;
        while (t!=null){
            t=t.next;
            len2++;
        }
        int last = 0;
        if(len1>len2){
            last = magic2(l1, l2, 0, len1-len2);
            if(last>0){
                ListNode head = new ListNode(last);
                head.next = l1;
                return head;
            }else{
                return l1;
            }

        }else if(len2>len1){
            last = magic2(l2, l1, 0, len2-len1);
            if(last>0){
                ListNode head = new ListNode(last);
                head.next = l2;
                return head;
            }else{
                return l2;
            }
        }else{   // 两个链表相等
            last = magic(l1, l2);
            if(last>0){
                ListNode head = new ListNode(last);
                head.next = l1;
                return head;
            }else{
                return l1;
            }
        }

    }

    public ListNode generalList(int[] datas){
        ListNode head = new ListNode(datas[0]);
        ListNode t = head;
        for(int i=1;i<datas.length;i++){
            ListNode rem = new ListNode(datas[i]);
            t.next = rem;
            t = t.next;
        }
        return head;
    }

    public static void main(String[] args) {
        AddTwoNumbersii addTwoNumbersii = new AddTwoNumbersii();
        int[] datas1 = {9};
        int[] datas2 = {9,1};
        ListNode listNode = addTwoNumbersii.addTwoNumbers(addTwoNumbersii.generalList(datas1), addTwoNumbersii.generalList(datas2));
        System.out.println("end");
    }

}
