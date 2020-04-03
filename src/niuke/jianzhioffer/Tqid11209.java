package niuke.jianzhioffer;

public class Tqid11209 {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }


    public ListNode deleteDuplication(ListNode pHead) {
        // 如果列表为空直接返回
        if(pHead==null)
            return pHead;
        // 创建一个头指针，处理所有数据全部一样的情况
        ListNode head = new ListNode(0);
        head.next = pHead;
        // 用于记录当前数字的开始位置的前一个位置
        ListNode t = head;
        while (pHead!=null){
            // 每次读取两个数值
            ListNode a = pHead;
            ListNode b = pHead.next;
            // 如果遍历到结尾处则停止
            if(b==null){
                // 首先判断最后一个数字是不是重复数字，如果是则删除
                if(a!=t.next){
                    t.next = b;
                }
                break;
            }
            // 如果遇到重复数字则先遍历到重复数字的末尾
            if(a.val==b.val){
                pHead = b;
            }else{
                if(a==t.next){   // 表示没有重复
                    t = a;
                }else{   // 有重复
                    t.next = b;
                }
                pHead = b;
            }
        }
        return head.next;
    }

    public ListNode generalList(int[] datas){
        ListNode head = new ListNode(0);
        ListNode thead = head;
        for (int data : datas) {
            ListNode t = new ListNode(data);
            thead.next = t;
            thead = t;
        }
        return head.next;
    }

    public static void main(String[] args) {
        Tqid11209 tqid11209 = new Tqid11209();
        int[] datas = {1,1,1,1,1,1,1};
        ListNode listNode = tqid11209.generalList(datas);
        tqid11209.deleteDuplication(listNode);
    }
}
