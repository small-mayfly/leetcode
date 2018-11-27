//
// Created by mayfly on 18-11-26.
//


#include <iostream>
#include <string>
using namespace std;
//没什么思路，所以想着直接判断了，代码太差
string intToRoman(int num) {
    string result="";
    int n;
    if(num>=1000){
        n=num/1000;
        for (int i = 0; i < n; ++i) {
            result+="M";
        }
        num=num-n*1000;
        if(num==0)
            return result;
    }
    if(num>=900){
        result+="CM";
        num-=900;
        if(num==0)
            return result;
    }
    if(num>=500){
        result+="D";
        num-=500;
        if(num==0)
            return result;
    }
    if(num>=400){
        result+="CD";
        num-=400;
        if(num==0)
            return result;
    }
    if(num>=100){
        n=num/100;
        for (int i = 0; i < n; ++i) {
            result+="C";
        }
        num=num-n*100;
        if(num==0)
            return result;
    }
    if(num>=90){
        result+="XC";
        num-=90;
        if(num==0)
            return result;
    }
    if(num>=50){
        result+="L";
        num-=50;
        if(num==0)
            return result;
    }
    if(num>=40){
        result+="XL";
        num-=40;
        if(num==0)
            return result;
    }
    if(num>=10){
        n=num/10;
        for (int i = 0; i < n; ++i) {
            result+="X";
        }
        num=num-n*10;
        if(num==0)
            return result;
    }
    if(num==9){
        result+="IX";
        return result;
    }
    if(num>=5){
        result+="V";
        num-=5;
        for (int i = 0; i < num; ++i) {
            result+="I";
        }
        return result;
    }
    if(num==4){
        result+="IV";
        return result;
    }
    for (int j = 0; j < num; ++j) {
        result+="I";
    }
    return result;
}
int main(){
    cout<<intToRoman(1994)<<endl;
    return 0;
}