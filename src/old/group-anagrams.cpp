//
// Created by mayfly on 2019/2/7.
//

#include <iostream>
#include <vector>
#include <string>
#include<algorithm>
#include <unordered_map>

using namespace std;
vector<vector<string>> groupAnagrams(vector<string>& strs);
string sort_str(string s);
int main(){
    vector<vector<string>> marg;
    vector<string> targ;
    targ.push_back("eat");
    targ.push_back("tea");
    targ.push_back("tan");
    targ.push_back("ate");
    targ.push_back("nat");
    targ.push_back("bat");
    marg=groupAnagrams(targ);
    for (int i = 0; i < marg.size(); ++i) {
        for (int j = 0; j < marg[i].size(); ++j) {
            cout<<marg[i][j]<<" ";
        }
        cout<<endl;
    }
    return 0;
}
vector<vector<string>> groupAnagrams(vector<string>& strs) {
    vector<vector<string>> result;//保存分组结果
    unordered_map<string,int> m;//利用映射结构加速，string是字符串排序后的结果，int记录string对应的result的分组id
    result.push_back({"temp"});//加入一个temp，用以处理第一个id为0的异常情况
    m["temp"]=0;
    int str_num=strs.size();//获取字符串个数
    for (int i = 0; i < str_num; ++i) {
        string t_str=sort_str(strs[i]);//获取当前字符串对应的key
        if(m[t_str]==0){//如果之前没有出现对应的分组则新建分组
            result.push_back({strs[i]});
            m[t_str]=result.size()-1;
        }else{//已经出现过分组，则直接加入分组
            result[m[t_str]].push_back(strs[i]);
        }
    }
    result.erase(result.begin());//删除temp临时分组
    return result;
}
//将字符串进行排序，将排序结果设置为key，利用hash函数将复杂度控制为O(n)
string sort_str(string s){
    string result="";
    int hash_s[26]={0};
    for (int i = 0; i < s.length(); ++i) {
        ++hash_s[s[i]-'a'];
    }
    for (int j = 0; j < 26; ++j) {
        for (int k = 0; k < hash_s[j]; ++k) {
            result+=((char)(j+'a'));
        }
    }
    return result;
}
