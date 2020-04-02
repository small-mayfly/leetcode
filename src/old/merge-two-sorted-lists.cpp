//
// Created by mayfly on 18-12-6.
//

#include <iostream>
using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};
//因为是已经排好序的，所以只需要遍历一遍就可以了
ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
    //如果某个u序列为空则直接返回另一个序列
    if(l1 == nullptr)
        return l2;
    else if(l2 == nullptr)
        return l1;
    else{//两个都不为空则开始遍历
        ListNode *start, *temp;
        if (l1->val>l2->val){//找到第一个节点
            start=l2;
            l2=l2->next;
        }else{
            start=l1;
            l1=l1->next;
        }
        temp = start;
        while(true){//从头节点开始向后遍历
            if(l1 == nullptr){//如果某一时刻只剩一个序列则直接返回
                temp->next = l2;
                break;
            }else if(l2 == nullptr){
                temp->next = l1;
                break;
            }else{//两个序列都不为空则判断两个序列，取较小值
                if (l1->val>l2->val){
                    temp->next=l2;
                    temp=temp->next;
                    l2=l2->next;
                }else{
                    temp->next=l1;
                    temp=temp->next;
                    l1=l1->next;
                }
            }
        }
        return start;
    }
}

int main(){
    return 0;
}