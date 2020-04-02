package hard;


class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}
public class ReverseNodesInkGroup {
	/**
	 * 用于将链表前k个反转的函数，思路比较简单新建一个长度为k的数组，将链表前k个节点倒叙放入数组中，然后正序读出来
	 * @param head 链表的头指针
	 * @param k 设定反转节点的个数
	 * @return 前k个节点反转过后的链表
	 */
	public ListNode reverseList(ListNode head, int k) {
		// 判断列表长度，如果列表长度小于k则直接返回
		ListNode t = head;   // 获取链表头指针
		int remL = 0;   // 记录当前链表长度
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
		// 如果链表长度大于等于k，则执行函数
		ListNode result = null;   // 记录返回结果
		ListNode tail = null;   // 记录当前链表第k+1个节点的位置，用于恢复反转过后链表的连接
		ListNode[] temp = new ListNode[k];   // 创建用于临时记录节点的数组
		for(int i=0;i<k;i++) {   // 将链表倒叙放入数组中
			temp[k-1-i] = head;
			head = head.next;
		}
		result = temp[0];   // 因为是倒序放，所以数组第一个存放的是链表第k个节点
		tail = result.next;   // 获取链表第k+1个节点
		head = result;   // 获取新的反转过后链表的头部
		for(int i=1;i<k;i++) {   // 依次遍历数组，生成反转过后的链表
			head.next = temp[i];
			head = head.next;
		}
		head.next = tail;   // 将反转过后链表的第k个值的next指向第k+1个点，恢复链表的连接
		return result;   // 返回结果
	}
	
	
	/**
	 * 首先排除异常链表，然后对正常链表进行反转
	 * @param head 链表头指针
	 * @param k 反转个数
	 * @return
	 */
	public ListNode reverseKGroup(ListNode head, int k) {
		// 如果链表为空，直接返回即可
		if(head == null)
			return null;
		// 如果链表长度小于k，也直接返回
		ListNode trem = head;
		for(int i=0;i<k-2;i++) {
			if(trem!=null)
				trem = trem.next;
			else
				break;
		}
		if(trem==null || trem.next==null)
			return head;
		// 如果k==1，则直接返回结果
		if(k==1)
			return head;
		// 否则开始向后循环遍历
		ListNode result = head;
		ListNode nextHead = head;   // 用于记录下一个要交换序列的链表的头结点
		ListNode tail = null;   // 记录当前已更换链表的最后一个节点
		result = reverseList(head, k);   // 将链表前k个节点反转
		tail = head;   // 前k个节点反转过后，head指向的是第k个节点，所以此时的tail就是head
		nextHead = head.next;   // 获取第k+1个节点
		while(nextHead!=null){   // 如果还有没有反转的链表则继续向后k个节点一组进行反转
			tail.next = reverseList(nextHead, k);   // 反转接下来的k个节点
			tail = nextHead;   // 更新tail指针
			nextHead = nextHead.next;   // 更新nextHead指针
		}
		return result;   // 返回生成结果
    }
	// 生成链表
	public ListNode generalList(int[] datas) {
		ListNode result = new ListNode(datas[0]);   // 链表头指针
		result.next = null;
		ListNode tresult = result;   // 记录链表当前生成点位置
		for(int i=1;i<datas.length;i++) {   // 循环生成链表
			tresult.next = new ListNode(datas[i]);
			tresult = tresult.next;
			tresult.next = null;
		}
		return result;   // 返回结果
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
