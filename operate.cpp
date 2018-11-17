//
// Created by mayfly on 18-11-17.
//

#include <iostream>
#include <string>
using namespace std;
//从头到尾仅遍历一边，复杂度为O(n)但需要遍历子串增加了复杂度。可用hashmap或数组来取代字符串遍历降低复杂度

int lengthOfLongestSubstring(string s) {
    int nlesl=0;//记录当前最长无重子串长度
    string nles="";//记录当前最长无重子串
    string ns="";//记录当前操作子串
    int strLen=s.length();//获取字符串s长度
    int flag=0;//记录是否有重复字符
    char now_ope_char;//当前判断的字符
    int j;
    for (int i = 0; i < strLen; ++i) {
        now_ope_char=s[i];//读取当前要判断的字符
        for (j = 0; j < ns.length(); ++j) {
            if (ns[j]==now_ope_char){
                flag=1;
                break;
            }
        }
        if(flag==1){//说明有重复字符，需要操作
            flag=0;//复原flag供下一个循环使用
            if (ns.length()>nlesl){//当前获取的无重子串长度比已获得的长，则替换记录
                nles=ns;
                nlesl=ns.length();
            }
            ns=ns.substr(j+1);//截取重复字符后面字符的子串
        }
        ns+=now_ope_char;//将当前字符添加到临时记录字符串中
    }
    if(ns.length()>nlesl){//排除最后子串无重复并且是最长的bug
        nlesl=ns.length();
        nles=ns;
    }
    return nlesl;
}

int main()
{
    string s= "pwwkew";
    int tl=lengthOfLongestSubstring(s);
    cout<<tl<<endl;
    return 0;
}