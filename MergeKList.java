package daily;

class ListNode {
	int val;
	ListNode next;
	ListNode(int x){ val = x; }
}


public class MergeKList {
	
	public ListNode mergeKLists(ListNode[] lists) {
		
		ListNode result = new ListNode(0);   // 生成结果列表
		ListNode tresult = result;   // 临时记录当前节点
		int listNum = lists.length;   // 获取总的列表个数
		int flag = listNum;   // 记录当前可用的列表个数，如果都不可用，说明已经遍历完所有的列表可以结束
		int min_index = -1;   // 记录当前获取到的最小值在哪个list
		while(flag>0) {
			flag = listNum;
			for(int i=0; i<listNum; i++) {   // 遍历所有列表，找出当前列最小值
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
			if(tresult.next!=null) {   // 将选中的列表头结点后移一个，同时将tresult指向下一个节点
				lists[min_index] = lists[min_index].next;
				tresult = tresult.next;
				tresult.next = null;
			}
		}
		return result.next;
    }
	
	public ListNode generalList(int[] args) {
		// 获取参数长度
		int argsNum = args.length-2;
		// 构造返回列表
		ListNode result = new ListNode(args[argsNum+1]);
		result.next = null;   // next为空
		ListNode nowNode = null; // 用于临时记录新的点
		// 按照倒叙生成结果列表
		while(argsNum>=0) {
			nowNode = new ListNode(args[argsNum]);   // 生成新的节点
			nowNode.next = result;   // 新节点.next指向后一个节点
			
			result = nowNode;   // result指向列表头部
			argsNum--;
		}
		// 返回结果
		return result;
		
	}

	public static void main(String[] args) {
		MergeKList mkl = new MergeKList();
		
		ListNode[] lists = new ListNode[3];
		
		// 用于验证生成函数的正确性
//		int[] tt = {1, 4, 5};
//		ListNode t = mkl.generalList(tt);
//		while(t!=null) {
//			System.out.println(t.val);
//			t=t.next;
//		}
		
		// 构造样例
		int[] data1 = {1, 4, 5};
		int[] data2 = {1, 3, 4};
		int[] data3 = {2, 6};
		lists[0] = mkl.generalList(data1);
		lists[1] = mkl.generalList(data2);
		lists[2] = mkl.generalList(data3);
		
		
		// 执行函数
		ListNode t = mkl.mergeKLists(lists);   // 获取执行结果
		while(t!=null) {   // 输出执行结果
			System.out.println(t.val);
			t=t.next;
		}
		
		
		
		

	}

}

