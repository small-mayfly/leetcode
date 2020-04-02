//
// Created by mayfly on 18-12-5.
//

#include <iostream>
#include <string>
using namespace std;

bool isValid(string s) {
    int strLen = s.size();
    if (strLen == 0)//空字符串肯定是匹配的，返回true
        return true;
    int rem[strLen], index = 0;//用来模拟栈
    int t;//用来表示当前判断的字符
    //把括号专程数字，更容易进行判断
    for (int i = 0; i < strLen; ++i) {
        switch(s[i]){
            case '(':{
                t = -1;
                break;
            }
            case ')':{
                t = 1;
                break;
            }
            case '{':{
                t = -2;
                break;
            }
            case '}':{
                t = 2;
                break;
            }
            case '[':{
                t = -3;
                break;
            }
            case ']':{
                t = 3;
                break;
            }
        }
        if (t < 0){//左括号不需要匹配直接入栈
            rem[index++] = t;//入栈
        }else{
            if (index == 0){//地一个为右括号，肯定是错误的
                return false;
            }else{
                if(rem[index-1]+t==0){
                    index--;//如果括号匹配则出栈
                }else{
                    //如果括号不匹配说明有错误，报错
                    return false;
                }
            }
        }
    }
    if (index == 0){//所有已经判断的括号都是匹配的，则返回true
        return true;
    }else{//有部分左括号没有匹配到右括号，返回false
        return false;
    }
}

int main(){
    cout<<isValid("")<<endl;
    return 0;
}