//
// Created by mayfly on 18-11-22.
//

#include <iostream>

#include <math.h>
using namespace std;
int myAtoi(string str) {
    int startIndex=0;
    int strLen=str.length();
    //去掉开头的空格
    while(str[startIndex]==' ' && startIndex<strLen){
        startIndex++;
    }
    if(startIndex==strLen){//全空字符串，返回0
        return 0;
    }
    else if((str[startIndex]>='0' && str[startIndex]<='9') || str[startIndex]=='-' || str[startIndex]=='+'){//计算数字
        string numStr="";//用以存储数字
        int result;
        if(str[startIndex]=='-'){//小于0的数
            startIndex++;
            while(str[startIndex]=='0' && startIndex<strLen){
                startIndex++;
            }
            if(startIndex==strLen)
                return 0;
            while(startIndex<strLen && (str[startIndex]>='0' && str[startIndex]<='9'))//获得数字
                numStr+=str[startIndex++];
            if(numStr.length()>10){//长度过大，数字溢出，返回最小负数
                return -2147483648;
            }else if(numStr.length()==10){//存在溢出的可能，再进行判断
                string pStr="2147483648";//如果溢出返回最小值
                for (int i = 0; i < 10; ++i) {
                    if(pStr[i]>numStr[i]){
                        break;
                    }
                    if(pStr[i]<numStr[i]){
                        return -2147483648;
                    }
                }
                //不溢出则进行转换
                result=0;
                for (int i = 0; i < 10; ++i) {
                    result=result*10+(numStr[i]-'0');
                }
                return -result;
            }else{//一定不溢出，考虑直接处理输出
                result=0;
                for (int i = 0; i < numStr.length(); ++i) {
                    result=result*10+(numStr[i]-'0');
                }
                return -result;
            }
        }else{//正数
            if(str[startIndex]=='+')//如果有+则去掉
                startIndex++;
            while(str[startIndex]=='0' && startIndex<strLen){
                startIndex++;
            }
            if(startIndex==strLen)
                return 0;
            while(startIndex<strLen && (str[startIndex]>='0' && str[startIndex]<='9'))//获得数字
                numStr+=str[startIndex++];
            if(numStr.length()>10){//长度过大，数字溢出，返回最小负数
                return 2147483647;
            }else if(numStr.length()==10){//存在溢出的可能，再进行判断
                string pStr="2147483647";//如果溢出返回最小值
                for (int i = 0; i < 10; ++i) {
                    if(pStr[i]>numStr[i]){
                        break;
                    }
                    if(pStr[i]<numStr[i]){
                        return 2147483647;
                    }
                }
                //不溢出则进行转换
                result=0;
                for (int i = 0; i < 10; ++i) {
                    result=result*10+(numStr[i]-'0');
                }
                return result;
            }else{//一定不溢出，考虑直接处理输出
                result=0;
                for (int i = 0; i < numStr.length(); ++i) {
                    result=result*10+(numStr[i]-'0');
                }
                return result;
            }
        }
    }else{
        return 0;//首字符不是0～9并且不是+-，则返回0
    }
}
int main(){
    int result=2147483647;
    string str="1095502006p8";
    cout<<myAtoi(str)<<endl;
    return 0;
}
