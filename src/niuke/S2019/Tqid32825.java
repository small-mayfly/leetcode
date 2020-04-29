package niuke.S2019;

import java.util.*;

public class Tqid32825{
    /**
     * 遍历规律，数字%3结果为1、0、0、1、0、0、1、0、0、1、0、0
     * 呈现明显的规律性，所以不需要遍历，只需要直接计算个数即可
     * @param args
     */
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String[] datas = in.nextLine().split(" ");
        int start = Integer.parseInt(datas[0]);
        int end = Integer.parseInt(datas[1]);

        int count = end-start+1;
        int base = count/3*2;
        int sy = count%3;
        // 分start的三种开始位置分别处理
        if(sy>0){
            if(start%3==1){
                if(sy==2)
                    base++;
            }else if(start%3==2){
                base+=sy;
            }else{
                if(sy==1)
                    base++;
            }

        }
        System.out.println(base);


//        int initData = 1;
//        int remCount = 0;
//        for(int i=2;i<=end;i++){
//            initData = Integer.parseInt(initData + "" + i);
//            int sy = initData % 3;
//            if(i>=start){
//                if(sy==0)
//                    remCount++;
//                }
//            initData = sy;
//        }
//        System.out.println(remCount);
    }
}

