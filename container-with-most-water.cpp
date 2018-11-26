//
// Created by mayfly on 18-11-26.
//

#include <iostream>
#include <vector>
using namespace std;
//使用遍历的方法查找，复杂度O(n^2)，速度超过20.98%的同学们
int maxArea(vector<int>& height) {
    int vLen=height.size();
    int rem[vLen][vLen];
    int volume=0;
    int minHeight=0;
    int o;
    //初始化记录矩阵
    for (int i = 0; i < vLen; ++i) {
        for (int j = 0; j < i; ++j) {
            minHeight=height[i]>height[j]?height[j]:height[i];
            o=minHeight*(i-j);
            if(o>volume){
                volume=o;
            }
        }
    }
    return volume;

}
int main(){
    vector<int> rem={1,8,6,2,5,4,8,3,7};
    cout<<maxArea(rem)<<endl;
    return 0;
}