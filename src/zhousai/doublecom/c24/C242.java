package zhousai.doublecom.c24;

import java.util.ArrayList;

public class C242 {

    // 记录斐波那契数列
    ArrayList<Integer> rems = new ArrayList<Integer>();

    /**
     * 使用贪心算法
     * 每次选取不大于k的最大值x，接下来选择不大于k-x的最大值，直到k-x==0程序结束
     * 贪心算法的正确性可以如下证明
     * 1. 因为fn=fn-1+fn-2，所以不可能选取连续的两个值
     * 2. ,假设n为偶数，若fn<k<fn+1，如果fn不是组成k的元素之一，因为f1+f2+f3+f4+...+fn-1=f3+f5+f7+...+fn-1<fn，所以累加和不可能达到k
     * @param k
     * @return
     */
    public int findMinFibonacciNumbers(int k) {
        // 如果结果已知，直接返回
        if(k==1)
            return 1;
        else if(k==2){
            return 1;
        }
        if(rems.size()<2){
            rems.add(0);
            rems.add(1);
            rems.add(1);
        }
        if(rems.get(rems.size()-1)<=k){
            int t = rems.get(rems.size()-1)+rems.get(rems.size()-2);
            rems.add(t);
            while (t<=k){
                t = rems.get(rems.size()-1)+rems.get(rems.size()-2);
                rems.add(t);
            }
        }
        int index = 0;
        for(int i=1;i<rems.size()-1;i++){
            if(rems.get(i)<k && rems.get(i+1)>k){
                index = i;
                break;
            }else if(rems.get(i)==k){
                return 1;
            }
        }
        return 1 + findMinFibonacciNumbers(k-rems.get(index));

    }


    public static void main(String[] args) {
        C242 c242 = new C242();
        int data = 5;
        System.out.println(c242.findMinFibonacciNumbers(data));
    }
}
