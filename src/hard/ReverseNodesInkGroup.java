package hard;


class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}
public class ReverseNodesInkGroup {
	/**
	 * ���ڽ�����ǰk����ת�ĺ�����˼·�Ƚϼ��½�һ������Ϊk�����飬������ǰk���ڵ㵹����������У�Ȼ�����������
	 * @param head �����ͷָ��
	 * @param k �趨��ת�ڵ�ĸ���
	 * @return ǰk���ڵ㷴ת���������
	 */
	public ListNode reverseList(ListNode head, int k) {
		// �ж��б��ȣ�����б���С��k��ֱ�ӷ���
		ListNode t = head;   // ��ȡ����ͷָ��
		int remL = 0;   // ��¼��ǰ������
		for(int i=0;i<k;i++) {
			if(t!=null) {
				remL++;
				t = t.next;
			}else {
				break;
			}
		}
		if(remL<k)
			return head;
		// ��������ȴ��ڵ���k����ִ�к���
		ListNode result = null;   // ��¼���ؽ��
		ListNode tail = null;   // ��¼��ǰ�����k+1���ڵ��λ�ã����ڻָ���ת�������������
		ListNode[] temp = new ListNode[k];   // ����������ʱ��¼�ڵ������
		for(int i=0;i<k;i++) {   // �����������������
			temp[k-1-i] = head;
			head = head.next;
		}
		result = temp[0];   // ��Ϊ�ǵ���ţ����������һ����ŵ��������k���ڵ�
		tail = result.next;   // ��ȡ�����k+1���ڵ�
		head = result;   // ��ȡ�µķ�ת���������ͷ��
		for(int i=1;i<k;i++) {   // ���α������飬���ɷ�ת���������
			head.next = temp[i];
			head = head.next;
		}
		head.next = tail;   // ����ת��������ĵ�k��ֵ��nextָ���k+1���㣬�ָ����������
		return result;   // ���ؽ��
	}
	
	
	/**
	 * �����ų��쳣����Ȼ�������������з�ת
	 * @param head ����ͷָ��
	 * @param k ��ת����
	 * @return
	 */
	public ListNode reverseKGroup(ListNode head, int k) {
		// �������Ϊ�գ�ֱ�ӷ��ؼ���
		if(head == null)
			return null;
		// ���������С��k��Ҳֱ�ӷ���
		ListNode trem = head;
		for(int i=0;i<k-2;i++) {
			if(trem!=null)
				trem = trem.next;
			else
				break;
		}
		if(trem==null || trem.next==null)
			return head;
		// ���k==1����ֱ�ӷ��ؽ��
		if(k==1)
			return head;
		// ����ʼ���ѭ������
		ListNode result = head;
		ListNode nextHead = head;   // ���ڼ�¼��һ��Ҫ�������е������ͷ���
		ListNode tail = null;   // ��¼��ǰ�Ѹ�����������һ���ڵ�
		result = reverseList(head, k);   // ������ǰk���ڵ㷴ת
		tail = head;   // ǰk���ڵ㷴ת����headָ����ǵ�k���ڵ㣬���Դ�ʱ��tail����head
		nextHead = head.next;   // ��ȡ��k+1���ڵ�
		while(nextHead!=null){   // �������û�з�ת��������������k���ڵ�һ����з�ת
			tail.next = reverseList(nextHead, k);   // ��ת��������k���ڵ�
			tail = nextHead;   // ����tailָ��
			nextHead = nextHead.next;   // ����nextHeadָ��
		}
		return result;   // �������ɽ��
    }
	// ��������
	public ListNode generalList(int[] datas) {
		ListNode result = new ListNode(datas[0]);   // ����ͷָ��
		result.next = null;
		ListNode tresult = result;   // ��¼����ǰ���ɵ�λ��
		for(int i=1;i<datas.length;i++) {   // ѭ����������
			tresult.next = new ListNode(datas[i]);
			tresult = tresult.next;
			tresult.next = null;
		}
		return result;   // ���ؽ��
	}
	public static void main(String[] args) {
		ReverseNodesInkGroup rng = new ReverseNodesInkGroup();
		int[] datas = {1, 2, 3, 4, 5};
		ListNode lists = rng.generalList(datas);
		ListNode temp = rng.reverseKGroup(lists, 2);
		while(temp!=null) {
			System.out.println(temp.val);
			temp=temp.next;
		}
	}
}
