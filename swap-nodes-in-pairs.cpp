//
// Created by mayfly on 18-12-11.
//

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(nullptr) {}
};
//遍历一遍结束
ListNode* swapPairs(ListNode* head) {
    ListNode * t1= nullptr;//记录两个值中的地一个
    ListNode *t2= nullptr;//记录两个值中的第二个
    ListNode *temp= nullptr;//记录临时指针变量
    ListNode *pre= nullptr;//记录当前两个节点的前一个
    temp=head;//从头开始
    while(temp!= nullptr){//节点数量为偶数时，便利到空就结束了
        t1=temp;//第一个值
        temp=temp->next;
        if(temp!= nullptr){//处理节点数为奇数的情况
            t2=temp;//获取第二个值
            temp=temp->next;
            if(t1==head){//如果i是头节点，则交换头节点
                t1->next=t2->next;
                t2->next=t1;
                head=t2;
                pre=head->next;
            }else{//如果不是则正常交换
                pre->next=t2;
                t1->next=t2->next;
                t2->next=t1;
                pre=t1;
            }
        } else{
            break;
        }
    }
    return head;
}

int main(){

    return 0;
}