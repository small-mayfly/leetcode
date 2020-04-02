package medium;

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

/**
 * 总体思路较为简单，且复杂度较低，只需要遍历一遍即可
 * 1. 如果链表为空，则直接返回
 * 2. 如果链表只有一个节点，直接返回即可
 * 3. 如果链表有多个节点，则循环交换位置然后输出
 * 	3.1. 首先取第二个节点当做返回节点的头结点
 * 	3.2. 然后去输入链表的头结点当做当前已经交换过的链表的头结点
 * 	3.3. 将交换位置节点的next进行修改，并将前两个置为已经转换列表，剩余部分作为未交换列表，并始终用head指向未交换列表的头结点
 * 	3.4. 循环执行1-3.3，直到最后，返回结果
 * @author mayfly
 *
 */
public class SwapNodesinPairs {
	public ListNode swapPairs(ListNode head) {
		// 如果链表为空则直接返回null
		if(head == null)
			return null;

		// 如果链表长度为1，则直接返回头结点
		ListNode nowPair = head;
		if(nowPair.next==null) {
			return head;
		}
		
		// 否则开始循环遍历
		ListNode result = null;   // 指向结果链表的头结点
		ListNode nowIndex = null;   // nowIndex指向当前已经反转的最后一个节点，也就是链表的末尾
		// 首先获取结果头
		result = head.next;
		head.next = result.next;
		result.next = head;
		// nowIndex指向当前已经反转的最后一个节点，也就是链表的末尾
		nowIndex = result.next;
		// 因为头结点已经没用，所以用它向后遍历，始终指向未连接部分的头部
		head = nowIndex.next;
		while(head!=null) {
			if(head.next==null) {   // 如果这是最后一个节点，则将最后一个节点连接过后，直接返回即可
				nowIndex.next = head;
				break;
			}else {
				nowIndex.next = head.next;   // 当前链表的最后一个节点，指向未连接链表的第二个节点
				head.next = nowIndex.next.next;   // 将未连接链表头结点.next指向未连接链表的第三个节点
				nowIndex.next.next = head;   // 将当前已连接链表的最后一个节点的.next.next设置为未连接链表的头结点，至此已经完成未连接链表的第一第二个节点位置的转换
				// 之后只需要更新已连接链表和未连接链表的状态即可
				nowIndex = nowIndex.next.next;   // 更新已连接链表的结尾
				head = nowIndex.next;   // 更新未连接链表的表头
			}
		}
		return result;
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
		// TODO Auto-generated method stub
		SwapNodesinPairs snp = new SwapNodesinPairs();
		int[] datas = {1,2,3,4};
		ListNode lists = snp.generalList(datas);
		
		ListNode result = snp.swapPairs(lists);
		// 循环输出转换过后链表的结果
		while(result!=null) {
			System.out.println(result.val);
			result = result.next;
		}
	}
}
