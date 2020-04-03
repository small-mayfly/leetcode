package niuke.jianzhioffer;

import java.util.Arrays;

public class Tqid11198 {


    public boolean isContinuous(int [] numbers) {
        if(numbers.length==0)
            return false;
        Arrays.sort(numbers);
        int count = 0;
        // 找出王的个数
        while (numbers[count]==0)
            count++;

        if(numbers.length-count<2)
            return true;

        if(numbers[numbers.length-1]-numbers[count]>numbers.length)
            return false;

        int index = count+1;
        int last = numbers[count];
        while (count>=0 && index<numbers.length){
            if(numbers[index]-last==0)
                return false;
            if(numbers[index]-last>1){
                int tdata = numbers[index]-last-1;
                count -= tdata;
                if(count<0)
                    return false;
            }
            last = numbers[index++];
        }

        return true;
    }

    public static void main(String[] args) {
        Tqid11198 tqid11198 = new Tqid11198();
        int[] datas = {0,0,0, 1, 3, 5, 6, 8, 9, 10, 12};
        System.out.println(tqid11198.isContinuous(datas));
    }

}
