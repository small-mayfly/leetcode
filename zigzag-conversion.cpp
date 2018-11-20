//
// Created by mayfly on 18-11-20.
//

#include <iostream>
#include <string>
using namespace std;
string convert(string s, int numRows) {
    string retStr="";
    if (numRows>1){
        int strLen=s.length();//获取字符长度
        string rem[numRows];//用于记录每一行的字符
        int i=0;
        int dire=0;//记录方向
        int tlen=0;
        while(tlen<strLen){
            rem[i]=rem[i]+s[tlen];//将当前字符添加到记录的字符串中
            if(dire==0){//向下
                if(i==numRows-1){//到底转向
                    dire=1;
                    i--;
                }else{//没到底继续向下
                    i++;
                }
            }else{//向上
                if(i==0){//到顶转向
                    dire=0;
                    i++;
                }else{//没到顶继续
                    i--;
                }
            }
            tlen++;
        }

        for (int j = 0; j < numRows; ++j) {
            retStr+=rem[j];
        }
    }else{
        retStr=s;
    }
    return retStr;

}

int main(){
    string s="PAYPALISHIRING";
    int numRows=3;
    cout<<s<<endl;

    cout<<convert(s,numRows)<<endl;
    return 0;
}