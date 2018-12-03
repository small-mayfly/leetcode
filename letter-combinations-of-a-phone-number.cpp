//
// Created by mayfly on 18-12-3.
//

#include <iostream>
#include <string>
#include <vector>
using namespace std;
//用进位的方法生成全排列，来循环输出所有结果
vector<string> letterCombinations(string digits) {
    int strLen=digits.size();//获取字符串长度
    vector<string> result;
    if(strLen<1){
        return result;
    }
    vector<vector<char>> digitRem;
    int index = 0;
    //生成每个数字对应的单词
    for (int i = 2; i < 10; ++i) {
        vector<char> trem;
        for (int j = 0; j < 3; ++j) {
            trem.push_back('a'+index++);
        }
        if(i == 9 || i == 7){
            trem.push_back('a'+index++);
        }
        digitRem.push_back(trem);
    }
    int rem[strLen];
    int tFront[strLen];
    for (int k = 0; k < strLen; ++k) {
        tFront[k] = 0;
        if(digits[k] != '9' && digits[k] != '7'){
            rem[k]=3;
        }else{
            rem[k]=4;
        }
    }
    rem[0] += 1;
    string trem;
    while(tFront[0] < rem[0]-1){
        index = strLen -1 ;//记录当前操作位置
        trem="";
        for (int i = 0; i < strLen; ++i) {
            trem += digitRem[digits[i]-'0'-2][tFront[i]];//获取当前计算出的字符串
        }
        result.push_back(trem);
        //计算下一个应该输出的字符的索引值，并调整到正确的进位
        tFront[index]++;//下一个索引值
        while(tFront[index] >= rem[index]){//如果应该进位，则进位
            tFront[index--] = 0;
            tFront[index]++;
        }
    }
    return result;
}


int main(){
    vector<string> result = letterCombinations("7");
    return 0;
}
