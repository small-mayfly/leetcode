//
// Created by mayfly on 18-11-28.
//

#include <iostream>
#include <vector>
using namespace std;
//先对数组进行排序，然后每次选取一个值当作结果的负数，然后从两边向中间搜索，求另外两个数
vector<vector<int>> threeSum(vector<int>& nums) {
    vector<vector<int>> rem;
    int numsLen=nums.size();
    vector<int> all_nums;
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
    int startIndex ;//遍历的前指针
    int endIndex ;//遍历的后指针
    int result;//要计算的结果
    int tnum=numsLen;//循环的次数
    for(int i=0; i < tnum; ++i){
        if(numsLen < 3)//当总数小于3的时候，一定不需要计算，不可能存在结果，剪枝
            break;
        numsLen--;
        if(i > 0 && all_nums[0] == -result){//不是第一次循环则要考虑将与前者重复的值去掉，避免重复结果
            all_nums.erase(all_nums.begin());
            continue;
        }
        startIndex = 0;
        endIndex = numsLen - 1;
        result = -all_nums[0];
        all_nums.erase(all_nums.begin());
        int tresult;
        while(startIndex < endIndex){
            tresult = all_nums[startIndex] + all_nums[endIndex];
            if(tresult < result){//如果加和小于结果则前指针向后移动
                startIndex++;
            }else if(tresult > result){//结果大于要求的结果后指针向前移动
                endIndex--;
            }else{//如果等于，则将结果记录
                vector<int> trem;
                trem.push_back(-result);
                trem.push_back(all_nums[startIndex]);
                trem.push_back(all_nums[endIndex]);
                rem.push_back(trem);
                while(all_nums[endIndex] == all_nums[endIndex-1])//将重复值剪枝，避免重复结果
                    endIndex--;
                endIndex--;
                startIndex++;
            }
        }
    }
    return rem;
}

int main(){
    vector<int> mrem={-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
    vector<vector<int>> rem = threeSum(mrem);
    cout<<"end"<<endl;
    return 0;
}