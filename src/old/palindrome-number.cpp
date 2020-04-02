//
// Created by mayfly on 18-11-23.
//
#include <iostream>
using namespace std;
bool isPalindrome(int x) {
    if (x<0)//如果是负数一定不是回文数
        return false;
    else if(x==0){//0一定是回文数
        return true;
    }else{//正数且反转过后相等一定是回文数，否则不是回文数
        int rem=0;
        int t=x;
        while(t>0){
            rem=rem*10+t%10;
            t/=10;
        }
        if(rem==x){
            return true;
        }else{
            return false;
        }
    }
}
int main(){
    cout<<isPalindrome(-121)<<endl;
    return 0;
}