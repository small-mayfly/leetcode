package niuke.jianzhioffer;
/**
 * �ռ任ʱ�䣬��һ��ָ��Ŀռ䣬������k������
 * @author mayfly
 *
 */
public class ListEndK {
	
	public ListNodee FindKthToTail(ListNodee head,int k) {
		if(head==null)   // �������Ϊ�գ��򷵻�null
			return null;
		int len = 0;
		ListNodee nowNode = head;
		while(nowNode!=null && len<k) {   // ������ǰk��
			nowNode = nowNode.next;
			len++;
		}
		if(len==k) {// ��ʱ˵�����г��Ȳ�����k��������
			while(nowNode!=null) {   // ��������ֱ��β��
				nowNode = nowNode.next;
				head = head.next;
			}
			return head;
		}else {   // ���г��Ȳ���������null
			return null;
		}
		
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


class ListNodee {
    int val;
    ListNodee next = null;

    ListNodee(int val) {
        this.val = val;
    }
}