package daily;

class ListNode {
	int val;
	ListNode next;
	ListNode(int x){ val = x; }
}


public class MergeKList {
	
	public ListNode mergeKLists(ListNode[] lists) {
		
		ListNode result = new ListNode(0);   // ���ɽ���б�
		ListNode tresult = result;   // ��ʱ��¼��ǰ�ڵ�
		int listNum = lists.length;   // ��ȡ�ܵ��б����
		int flag = listNum;   // ��¼��ǰ���õ��б����������������ã�˵���Ѿ����������е��б���Խ���
		int min_index = -1;   // ��¼��ǰ��ȡ������Сֵ���ĸ�list
		while(flag>0) {
			flag = listNum;
			for(int i=0; i<listNum; i++) {   // ���������б��ҳ���ǰ����Сֵ
				if(lists[i]==null) {
					flag--;
				}else {
					if(tresult.next==null) {
						tresult.next = lists[i];
						min_index = i;
					}else {
						if(tresult.next.val > lists[i].val) {
							tresult.next = lists[i];
							min_index = i;
						}
					}
				}
			}
			if(tresult.next!=null) {   // ��ѡ�е��б�ͷ������һ����ͬʱ��tresultָ����һ���ڵ�
				lists[min_index] = lists[min_index].next;
				tresult = tresult.next;
				tresult.next = null;
			}
		}
		return result.next;
    }
	
	public ListNode generalList(int[] args) {
		// ��ȡ��������
		int argsNum = args.length-2;
		// ���췵���б�
		ListNode result = new ListNode(args[argsNum+1]);
		result.next = null;   // nextΪ��
		ListNode nowNode = null; // ������ʱ��¼�µĵ�
		// ���յ������ɽ���б�
		while(argsNum>=0) {
			nowNode = new ListNode(args[argsNum]);   // �����µĽڵ�
			nowNode.next = result;   // �½ڵ�.nextָ���һ���ڵ�
			
			result = nowNode;   // resultָ���б�ͷ��
			argsNum--;
		}
		// ���ؽ��
		return result;
		
	}

	public static void main(String[] args) {
		MergeKList mkl = new MergeKList();
		
		ListNode[] lists = new ListNode[3];
		
		// ������֤���ɺ�������ȷ��
//		int[] tt = {1, 4, 5};
//		ListNode t = mkl.generalList(tt);
//		while(t!=null) {
//			System.out.println(t.val);
//			t=t.next;
//		}
		
		// ��������
		int[] data1 = {1, 4, 5};
		int[] data2 = {1, 3, 4};
		int[] data3 = {2, 6};
		lists[0] = mkl.generalList(data1);
		lists[1] = mkl.generalList(data2);
		lists[2] = mkl.generalList(data3);
		
		
		// ִ�к���
		ListNode t = mkl.mergeKLists(lists);   // ��ȡִ�н��
		while(t!=null) {   // ���ִ�н��
			System.out.println(t.val);
			t=t.next;
		}
		
		
		
		

	}

}

