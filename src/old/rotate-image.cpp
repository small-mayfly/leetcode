//
// Created by mayfly on 2019/2/6.
//

#include <iostream>
#include <vector>

using namespace std;

void rotate(vector<vector<int>>& matrix);

int main(){
    vector<vector<int>> matrix;
    int a=3;
    for (int i = 0; i < a; ++i) {
        vector<int> tmatrix=vector<int>(a);
        matrix.push_back(tmatrix);
    }
    int rem=0;
    for (int j = 0; j < a*a; ++j) {
        if(j>0 && j%a==0)
            rem++;
        matrix[rem][j%a]=j+1;
    }
    for (int i = 0; i < a; ++i) {
        for (int j = 0; j < a; ++j) {
            cout<<matrix[i][j]<<" ";
        }
        cout<<endl;
    }
    cout<<endl;
    rotate(matrix);
    return 0;
}
void rotate(vector<vector<int>>& matrix) {
    int a=matrix.size();//记录二维数组的维数
    int temp=1;
    //二维数组的长宽相同，则直接对称就行
    int rem1=a/2,rem2;
    for (int i = 0; i < rem1; ++i) {
        rem2=a-i-1;
        for (int j = i; j < rem2; ++j) {
            //由于是顺时针旋转90度，所以每次要将一圈的四个元素挨个进行换位
            temp=matrix[i][j];
            matrix[i][j]=matrix[a-1-j][i];
            matrix[a-1-j][i]=matrix[a-1-i][a-1-j];
            matrix[a-1-i][a-1-j]=matrix[j][a-1-i];
            matrix[j][a-1-i]=temp;
        }
    }
}
