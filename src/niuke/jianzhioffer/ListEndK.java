package niuke.jianzhioffer;
/**
 * 空间换时间，用一个指针的空间，减少了k个遍历
 * @author mayfly
 *
 */
public class ListEndK {
	
	public ListNodee FindKthToTail(ListNodee head,int k) {
		if(head==null)   // 如果对列为空，则返回null
			return null;
		int len = 0;
		ListNodee nowNode = head;
		while(nowNode!=null && len<k) {   // 先跳过前k个
			nowNode = nowNode.next;
			len++;
		}
		if(len==k) {// 此时说明队列长度不少于k，向后遍历
			while(nowNode!=null) {   // 向后遍历，直到尾部
				nowNode = nowNode.next;
				head = head.next;
			}
			return head;
		}else {   // 队列长度不够，返回null
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