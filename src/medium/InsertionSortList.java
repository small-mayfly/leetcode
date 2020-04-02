package medium;

public class InsertionSortList {
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public void test(int[] datas) {
		ListNode ln = new ListNode(0);
		ListNode head = ln;
		for (int i : datas) {
			ln.next = new ListNode(i);
			ln = ln.next;
		}
		head = insertionSortList(head.next);
		while(head!=null) {
			System.out.println(head.val);
			head = head.next;
		}
	}
	
	public ListNode insertionSortList(ListNode head) {
		if(head==null) {
			return head;
		}else if(head.next==null)
			return head;
		else {
			ListNode newHead = new ListNode(0);
			newHead.next = head;
			ListNode ln = head;
			ListNode point = null;
			ListNode t = null;
			boolean flag = false;
			while(ln.next!=null) {
				point = newHead;
				flag = false;
				while(point.next!=ln.next) {
					if(point.next.val>=ln.next.val) {
						t = ln.next.next;
						ln.next.next = point.next;
						point.next = ln.next;
						ln.next = t;
						flag = true;
						break;
					}
					point = point.next;
				}
				if(flag) {
					
				}else {
					ln = ln.next;
				}
			}
			return newHead.next;
		}
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] datas = {4,2,1,3};
		new InsertionSortList().test(datas);
	}

}
