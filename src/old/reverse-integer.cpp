//
// Created by mayfly on 18-11-21.
//
#include <iostream>
#include <math.h>
using namespace std;
//每次除十来反转数字，但可能存在溢出问题，所以考虑用一个double型数字来判断反转后的数字是否溢出，如果溢出则返回0
int reverse(int x) {
    double temp;
    int result=0;
    int flag=0;
    if(x<0){
        flag=1;
        x*=-1;
    }
    while(x>0){
        temp=(double)result*10.0+x%10;
        result=result*10+x%10;
        x/=10;
        if(temp-result!=0){//判断反转后的数字是否溢出
            result=0;
            break;
        }
    }
    if(flag==1){
        result*=-1;
    }
    return result;
}
int main(){
    int x=1534236469;
    cout<<reverse(x)<<endl;
    return 0;
}
