package zhousai.doublecom.c20;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FisrtClass {
    /**
     * 根据数字二进制下的1的数目排序，如果1的数目相同则按照数字大小顺序排序
     * 实现思路比较简单，首先将数据放入一个list中，然后重载排序方法
     * @param arr
     * @return
     */
    public int[] sortByBits(int[] arr) {
        if(arr.length<2)
            return arr;
        else{
            ArrayList<Integer> data = new ArrayList<>();
            for (int i : arr) {
                data.add(i);
            }
            Collections.sort(data, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    int a = 0;
                    int b = 0;
                    int t1 = o1;
                    int t2 = o2;
                    while (o1>0){
                        a += (o1%2);
                        o1/=2;
                    }
                    while (o2>0){
                        b += (o2%2);
                        o2/=2;
                    }
                    if(a==b){   // 如果1的个数相同则按照数字大小排序
                        return t1-t2;
                    }
                    else{
                        return a-b;
                    }
                }
            });
            for(int i=0;i<arr.length;i++){
                arr[i] = data.get(i);
            }
            return arr;
        }

    }

    public static void main(String[] args) {
        int[] data = {1024,512,256,128,64,32,16,8,4,2,1};
        int[] tdata = new FisrtClass().sortByBits(data);
        for (int datum : tdata) {
            System.out.println(datum);
        }
    }
}
