//
// Created by mayfly on 18-11-24.
//

#include <iostream>
#include <string>
using namespace std;

//根据KMP算法改编，时间复杂度控制在O(n)，但是提交时遇到问题，样例中s="ab" && p=".*" is true,but s="ab" && p=".*c" is false.不知道为啥
bool isMatch(string s, string p) {
    bool flag= false;
    if(s.length()==0){
        flag=true;
    }else if(p.length()==0){
        flag=false;
    }else{
        int sLen=s.length();
        int next[sLen];
        int q, k;
        //生成next数组
        for (int i = 0; i < sLen; ++i) {
            next[i]=0;
        }
        for (q = 1,k = 0; q < sLen; ++q)//for循环，从第二个字符开始，依次计算每一个字符对应的next值
        {
            while(k > 0 && s[q] != s[k])//递归的求出P[0]···P[q]的最大的相同的前后缀长度k
                k = next[k-1];
            if (s[q] == s[k])//如果相等，那么最大相同前后缀长度加1
            {
                k++;
            }
            next[q] = k;
        }
        //开始遍历p数组
        int pLen=p.length();
        int srem=0, prem=0, psrem=0;
        //如果结尾为*则程序会越界，所以再结尾添加一个不可能匹配成功的字符
        if(p[pLen-1]=='*'){
            p=p+'A';
            pLen++;
        }
        //整体思路遵循KMP但对.*的处理导致程序有些许的编译
        while(prem<pLen) {
            if (s[srem] == p[prem]) {//匹配成功则向后移动
                prem++;
                psrem = srem++;
                while (p[prem] == '*')//如果遇到*则先跳过，判断时再回来
                    prem++;
            } else if (prem > 0 && p[prem - 1] == '*') {//如果匹配不成功但是当前字符的前一个字符为*则需要单独判断*
                if (s[srem] == p[prem - 2]) {//如果*之前的字符与当前字符一样则也是匹配成功，但是此时p的指针不需要向后移动
                    psrem = srem++;
                } else if (p[prem - 2] == '.') {//如果*之前为.则可以匹配所有字符，一定返回true，遍历结束
                    flag=true;
                    break;
                } else if(p[prem] == '.'){//如果当前字符为.则一定可以匹配，向后移动
                    prem++;
                    psrem = srem++;
                    while (p[prem] == '*')
                        prem++;
                } else {//不满足任一情况，回退
                    psrem = srem;
                    srem = next[srem];
                    prem++;
                    while (p[prem] == '*')
                        prem++;
                }
            } else if (p[prem] == '.'){//如果当前字符为.则一定可以匹配，向后移动
                prem++;
                psrem = srem++;
                while (p[prem] == '*')
                    prem++;
            } else {//不满足任一情况，回退
                psrem = srem;
                srem = next[srem];
                prem++;
                while (p[prem] == '*')
                    prem++;
            }
            if (srem == sLen) {
                flag = true;
                break;
            }
        }

    }
    return flag;
}

int main(){
    string s="ab";
    string p=".*c";
    cout<<isMatch(s,p)<<endl;
    return 0;
}