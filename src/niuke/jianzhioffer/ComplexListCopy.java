package niuke.jianzhioffer;

public class ComplexListCopy {

    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;
        RandomListNode(int label) {
            this.label = label;
        }
    }

    // 先重建整个链表，然后循环遍历设置random指针。
    public RandomListNode Clone(RandomListNode pHead)
    {
        // 为空直接返回即可
        if(pHead==null)
            return null;

        // 首先新建整个链表，只设置next指针，random指针暂时不做操作，同时将原链表中的label重置为当前节点所在的序号从0开始
        RandomListNode root = new RandomListNode(pHead.label);
        RandomListNode trem = root;
        RandomListNode nextPointer = pHead.next;
        int index = 1;
        pHead.label = 0;
        while(nextPointer!=null){
            RandomListNode temp = new RandomListNode(nextPointer.label);
            trem.next = temp;
            trem = temp;
            nextPointer.label = index;
            index++;
            nextPointer = nextPointer.next;
        }
        // 接下来设置random
        nextPointer = pHead;
        trem = root;
        RandomListNode temp = null;
        while (nextPointer!=null){
            if(nextPointer.random!=null){
                int t = nextPointer.random.label;
                temp = root;
                for(int i=0;i<t;i++){
                    temp = temp.next;
                }
                trem.random = temp;
            }
            trem = trem.next;
            nextPointer = nextPointer.next;
        }
        return root;
    }

    public static void main(String[] args) {

    }
}
