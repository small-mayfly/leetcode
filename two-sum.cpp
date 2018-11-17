#include <iostream>
#include <vector>
using namespace std;
vector<int> twoSum(vector<int>& nums, int target) {
    vector<int> remIndex;
    for (int k = 0; k < nums.size(); ++k) {
        remIndex.push_back(k);
    }
    //给vector排序
    int remInt;
    for (int i = 0; i < nums.size(); ++i) {
        for (int j = i+1; j < nums.size(); ++j) {
            if (nums.at(i)>nums.at(j)){
                remInt=nums[i];
                nums[i]=nums[j];
                nums[j]=remInt;
                remInt=remIndex[i];
                remIndex[i]=remIndex[j];
                remIndex[j]=remInt;

            }
        }
    }
    vector<int> temp;
    int index1=0,index2=nums.size()-1;
    while(index1<index2){
        if(nums.at(index1)+nums.at(index2)>target){
            index2--;
        }else if(nums.at(index1)+nums.at(index2)<target){
            index1++;
        }else{
            temp.push_back(remIndex[index1]);
            temp.push_back(remIndex[index2]);
            return temp;
        }
    }
}

int main() {
    vector<int> temp;
    temp.push_back(3);
    temp.push_back(2);
    temp.push_back(3);
//    temp.push_back(11);
    temp=twoSum(temp,6);
    for (int i = 0; i < temp.size(); ++i) {
        cout<<temp.at(i)<<endl;
    }
    return 0;
}