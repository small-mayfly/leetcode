//
// Created by mayfly on 18-11-16.
//

//Definition for singly-linked list.
struct ListNode {
    int val;
    ListNode *next;
};
ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
    //查找连个链表的长度，找到最长链表
    int len1=0,len2=0;
    ListNode* t1=l1;
    while(t1!= nullptr){
        len1++;
        t1=t1->next;
    }
    ListNode* t2=l2;
    while(t2!= nullptr){
        len2++;
        t2=t2->next;
    }
    ListNode* mLIst, * tList;
    if(len1>len2){
        mLIst=l1;
        tList=l2;
    }else{
        mLIst=l2;
        tList=l1;
        len1=len2;
    }
    int remFront=0;
    int t;
    t1=mLIst;
    ListNode* preNode= nullptr;
    while (tList != nullptr){
        t=mLIst->val+tList->val+remFront;
        mLIst->val=t%10;
        remFront = int(t/10);
        preNode=mLIst;
        mLIst=mLIst->next;
        tList=tList->next;
    }
    while(remFront>0){
        if(mLIst == nullptr){
            ListNode * mNode=new ListNode();
            mNode->val=1;
            mNode->next= nullptr;
            preNode->next=mNode;
        }else{
            mLIst->val++;
        }
        remFront=0;
        while(true){
            if(mLIst != nullptr && (mLIst->val+remFront)>9){
                t=mLIst->val+remFront;
                mLIst->val=t%10;
                remFront=1;
                preNode=mLIst;
                mLIst=mLIst->next;
            }else{
                break;
            }
        }
    }

    return t1;
}
int main(){
    ListNode *l1,*l2;
    l1=new ListNode[5];
    l2= new ListNode();
    l1[4].val=9;
    l1[3].val=8;
    l1[2].val=9;
    l1[1].val=9;
    l1[0].val=9;
    l1[0].next=&l1[1];
    l1[1].next=&l1[2];
    l1[2].next=&l1[3];
    l1[3].next=&l1[4];
    l2[0].val=1;
    l2[0].next= nullptr;
    ListNode *result;
    result=addTwoNumbers(l1,l2);
    return 0;
}