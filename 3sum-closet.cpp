//
// Created by mayfly on 18-12-2.
//

#include <iostream>
#include <vector>
#include <cmath>
using namespace std;

int threeSumClosest(vector<int>& nums, int target) {
    vector<int> rem;
    int numsLen=nums.size();
    vector<int> all_nums;
    int result=target;
    int flag;
    //对数组进行排序
    for (int i = 0; i < numsLen; ++i) {
        flag=0;
        for (int j = 0; j < i; ++j) {
            if(nums[i] < all_nums[j]){
                flag=1;
                all_nums.insert(all_nums.begin()+j, nums[i]);
                break;
            }
        }
        if(flag==0){
            all_nums.push_back(nums[i]);
        }
    }
    //无论如何当要将所有的三个数的情况计算一遍，所以不采用复杂度方法，转而采用简单的全便利
    //设置初始误差
    int now_error = abs(all_nums[0] + all_nums[1] + all_nums[2] - target);
    result = all_nums[0] + all_nums[1] + all_nums[2];
    int trem=1;
    int tresult;
    for (int k = 0; k < numsLen-2; ++k) {
        for (int i = k+1; i < numsLen-1; ++i) {
            for (int j = numsLen-1; j > i; --j) {
                tresult = all_nums[i] + all_nums[j] + all_nums[k];
                trem = abs(tresult - target);
                if (trem < now_error){
                    result = tresult;
                    now_error = trem;
                }
                if(j == i+1 && tresult > target){
                    trem = -1;//说明当前最小值比结果大，剪枝
                    break;
                }
                if(tresult < target){
                    break;//下一个结果应该比tresult还小，剪枝
                }
            }
            if (trem == -1)
                break;
        }
    }
    return result;
}

int main(){
    vector<int> a = {-1, 2, 1, 5};
    cout<< threeSumClosest(a, 1)<<endl;
    return 0;
}