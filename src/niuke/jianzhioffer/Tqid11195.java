package niuke.jianzhioffer;

import java.util.ArrayList;
import java.util.Arrays;

public class Tqid11195 {


    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        // 首先给数组排序
        Arrays.sort(array);
        // 依次判断
        int rem=Integer.MAX_VALUE;
        int a=0,b=0;
        for(int i=0;i<array.length;i++){
            for(int j=i+1;j<array.length;j++){
                int tdata = array[i]+array[j];
                if(tdata==sum){
                    if(array[i]*array[j]<rem){
                        a = array[i];
                        b = array[j];
                        rem = a*b;
                    }
                }else if(tdata>sum)
                    break;
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        result.add(a);
        result.add(b);
        return result;
    }

}
