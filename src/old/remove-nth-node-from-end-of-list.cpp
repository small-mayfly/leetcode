//
// Created by mayfly on 18-12-4.
//

#include <iostream>
using namespace std;
//从头遍历一遍，记录应当删除的点
struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

ListNode* removeNthFromEnd(ListNode* head, int n) {
    ListNode* temp;
    temp = head;
    if(temp->next == nullptr){
        return nullptr;
    }
    //由于题目中给出所有的n一定是不越界的，所以只需单独考虑n==1的情况就可排除单节点的情况
    if(n == 1){
        ListNode* pre;
        pre = head;
        temp = temp->next;
        while(temp->next != nullptr){
            pre = pre->next;
            temp = temp->next;
        }
        pre->next = nullptr;
    }else{
        int index = 1;//用它来记录是否用pre指向应当删除节点的前一个节点
        ListNode* pre;
        pre = temp;
        temp = temp->next;
        while(temp->next != nullptr){
            if(index < n){
                index++;
            }else{
                pre = pre->next;//找到第一个符合要求的节点后依次向后遍历
            }
            temp = temp->next;
        }
        if(index >= n){
            pre->next = pre->next->next;
        }else{
            head = head->next;
        }

    }
    return head;
}

int main(){

    return 0;
}