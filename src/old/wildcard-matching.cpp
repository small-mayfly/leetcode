//
// Created by mayfly on 2019/2/2.
//
#include <iostream>
#include <string>

using namespace std;
bool isMatch(string s, string p);
int main(){
    string s = "abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb";
    string p = "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb";
    s="aaaa";
    p="***a";
    cout<<isMatch(s,p)<<endl;
    return 0;
}
/***
 * 唯一需要注意的是*的情况，采用贪心策略，每次尽可能地向后匹配，匹配成功则一直向后匹配，匹配不成功则回滚到上一个一定匹配的位置
 * 以*为分界线，按照每个*来界定，某个*之前的是一定匹配的，之后的是可能匹配的
 * @param s
 * @param p
 * @return
 */
bool isMatch(string s, string p) {
    int len1,len2;
    len1=s.length();//获取字符串长度
    len2=p.length();//获取匹配符长度
    if(len1==0 && len2==0)//两个字符串都为空，则相等
        return true;
    if(len2==0)//匹配串为空则匹配不了任何串，为假
        return false;
    if(len1==0){//当被匹配串为空，匹配串不为空，则匹配串一定全为*
        for (int i = 0; i < len2; ++i) {
            if(p[i]!='*')
                return false;
        }
        return true;
    }
    int index1=0,index2=0;
    int rem_index1,rem_index2;//记录之前的一定匹配的位置
    rem_index1=-1;
    rem_index2=-1;
    while(index1<len1){
        if(index2<len2 && (s[index1]==p[index2] || p[index2]=='?')){
            index1++;
            index2++;
        }else if(index2<len2 && p[index2]=='*'){
            rem_index1=index1;///默认匹配规则为*匹配空，若不符合再向后+1
            rem_index2=index2;//已经确定到的位置
            index2++;
            if(index2==len2){//处理最后一位为*的情况
                return true;
            }
        }else{
            if(rem_index2==-1){//匹配直接失败
                return false;
            }
            index2=rem_index2+1;//从之前确定匹配的位置重新匹配
            index1=rem_index1+1;//*匹配空不符合则，默认多匹配一个字符
            rem_index1++;//此时如果能匹配成功，则能确定到当前位置
        }
    }
    while(p[index2]=='*')//处理额外的*
        index2++;
    if(index1==len1 && index2==len2)//完全匹配才为真，防止出现模式串有多余的情况
        return true;
    else
        return false;
}
