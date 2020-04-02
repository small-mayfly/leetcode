package niuke.jianzhioffer;

import java.util.ArrayList;
// �����ӡ����
public class PrintLinkedList {
	
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		
		ArrayList<Integer> result = new ArrayList<Integer>();
		if(listNode==null)
			return result;
		insert(listNode, result);
        return result;
    }
	// ʹ�õݹ鷽�����ȵݹ鵽����ײ���Ȼ���ٿ�ʼ��ӡ����
	public void insert(ListNode listNode, ArrayList<Integer> result) {
		if(listNode.next!=null)
			insert(listNode.next, result);
		result.add(listNode.val);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintLinkedList dylb = new PrintLinkedList();
		ListNode l = new ListNode(1);
		ListNode t = l;
		for(int i=0;i<5;i++) {
			t.next = new ListNode(i+2);
			t = t.next;
		}
		
		ArrayList<Integer> result = dylb.printListFromTailToHead(l);
		for(int i=0;i<result.size();i++) {
			System.out.println(result.get(i));
		}

	}

}
class ListNode {
	int val;
	ListNode next = null;
	
	ListNode(int val) {
		this.val = val;
	}
}