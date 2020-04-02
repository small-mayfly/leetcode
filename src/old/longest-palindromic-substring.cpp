//
// Created by mayfly on 18-11-19.
//

#include <iostream>
#include <string>
using namespace std;

string longestPalindrome(string s) {
    int strLen=s.length();//获取字符串长度
    int remIndex=0,remLen=1;//用于记录最长子串的开始下标和长度
    int tremIndex=0,tremLen=1;//用于记录临时子串的开始下标和长度
    int tLen1=1,tLen2=2;//用于设置查找字符之间的间隔，相同字符之间为偶数时用tLen1查找，为奇数时用tLen2查找
    for (int i = 1; i < strLen; ++i) {//从头遍历，间隔为奇数的情况
        if(i-tLen2>=0 && s[i]==s[i-tLen2]){
            tLen2+=2;//如果有回文子串类aba则下一个相同字符之间的间隔应该是当前距离+2
            if(tLen2-1>=remLen){//如果当前子串长度大于已知的最长子串则记录
                remLen=tLen2-1;
                remIndex=i-tLen2+2;
            }
            //记录临时子串的开始下表和长度，用于遍历索引的回朔，比如aaabaaa，aaab回朔后，下次查找为从b开始
            tremLen=tLen2-1;
            tremIndex=i-tLen2+2;
        }else{
            if(tLen2>2){//当当前子串出现断裂则开始回朔
                tLen2=2;
                i=tremIndex+tremLen/2+1;//回朔的下标
                continue;
            }
            tLen2=2;
        }

    }
    //思路与间隔为奇数的情况相同
    for (int i = 0; i < strLen; ++i) {
        if(i-tLen1>=0 && s[i]==s[i-tLen1]){
            tLen1+=2;
            if(tLen1-1>=remLen){
                remLen=tLen1-1;
                remIndex=i-tLen1+2;
            }
            tremLen=tLen1-1;
            tremIndex=i-tLen1+2;
        }else{
            if(tLen1>1){
                tLen1=1;
                i=tremIndex+tremLen/2;
                continue;
            }
            tLen1=1;
        }
    }
    return s.substr(remIndex,remLen);
}

int main(){
    int a=3/2;
    cout<<a<<endl;
    string s="aaabaaaa";
    cout<<longestPalindrome(s)<<endl;
    return 0;
}