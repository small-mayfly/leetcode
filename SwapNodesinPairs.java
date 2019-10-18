package medium;

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

/**
 * ����˼·��Ϊ�򵥣��Ҹ��ӶȽϵͣ�ֻ��Ҫ����һ�鼴��
 * 1. �������Ϊ�գ���ֱ�ӷ���
 * 2. �������ֻ��һ���ڵ㣬ֱ�ӷ��ؼ���
 * 3. ��������ж���ڵ㣬��ѭ������λ��Ȼ�����
 * 	3.1. ����ȡ�ڶ����ڵ㵱�����ؽڵ��ͷ���
 * 	3.2. Ȼ��ȥ���������ͷ��㵱����ǰ�Ѿ��������������ͷ���
 * 	3.3. ������λ�ýڵ��next�����޸ģ�����ǰ������Ϊ�Ѿ�ת���б�ʣ�ಿ����Ϊδ�����б���ʼ����headָ��δ�����б��ͷ���
 * 	3.4. ѭ��ִ��1-3.3��ֱ����󣬷��ؽ��
 * @author mayfly
 *
 */
public class SwapNodesinPairs {
	public ListNode swapPairs(ListNode head) {
		// �������Ϊ����ֱ�ӷ���null
		if(head == null)
			return null;

		// ���������Ϊ1����ֱ�ӷ���ͷ���
		ListNode nowPair = head;
		if(nowPair.next==null) {
			return head;
		}
		
		// ����ʼѭ������
		ListNode result = null;   // ָ���������ͷ���
		ListNode nowIndex = null;   // nowIndexָ��ǰ�Ѿ���ת�����һ���ڵ㣬Ҳ���������ĩβ
		// ���Ȼ�ȡ���ͷ
		result = head.next;
		head.next = result.next;
		result.next = head;
		// nowIndexָ��ǰ�Ѿ���ת�����һ���ڵ㣬Ҳ���������ĩβ
		nowIndex = result.next;
		// ��Ϊͷ����Ѿ�û�ã�����������������ʼ��ָ��δ���Ӳ��ֵ�ͷ��
		head = nowIndex.next;
		while(head!=null) {
			if(head.next==null) {   // ����������һ���ڵ㣬�����һ���ڵ����ӹ���ֱ�ӷ��ؼ���
				nowIndex.next = head;
				break;
			}else {
				nowIndex.next = head.next;   // ��ǰ��������һ���ڵ㣬ָ��δ��������ĵڶ����ڵ�
				head.next = nowIndex.next.next;   // ��δ��������ͷ���.nextָ��δ��������ĵ������ڵ�
				nowIndex.next.next = head;   // ����ǰ��������������һ���ڵ��.next.next����Ϊδ���������ͷ��㣬�����Ѿ����δ��������ĵ�һ�ڶ����ڵ�λ�õ�ת��
				// ֮��ֻ��Ҫ���������������δ���������״̬����
				nowIndex = nowIndex.next.next;   // ��������������Ľ�β
				head = nowIndex.next;   // ����δ��������ı�ͷ
			}
		}
		return result;
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
		// TODO Auto-generated method stub
		SwapNodesinPairs snp = new SwapNodesinPairs();
		int[] datas = {1,2,3,4};
		ListNode lists = snp.generalList(datas);
		
		ListNode result = snp.swapPairs(lists);
		// ѭ�����ת����������Ľ��
		while(result!=null) {
			System.out.println(result.val);
			result = result.next;
		}
	}
}
