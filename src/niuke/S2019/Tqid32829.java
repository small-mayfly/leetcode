package niuke.S2019;

import java.util.*;

public class Tqid32829 {
    public static void main(String[] args){
        // 首先获取所有输入
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        if(n<2 || n>50)
            return;
        int[] x1 = new int[n];
        int[] y1 = new int[n];
        int[] x2 = new int[n];
        int[] y2 = new int[n];

        int index = 0;
        String[] datas = in.nextLine().split(" +");
        for(String data: datas){
            x1[index] = Integer.parseInt(data);
            index++;
        }
        index = 0;
        String[] datas2 = in.nextLine().split(" +");
        for(String data: datas2){
            y1[index] = Integer.parseInt(data);
            index++;
        }
        index = 0;
        String[] datas3 = in.nextLine().split(" +");
        for(String data: datas3){
            x2[index] = Integer.parseInt(data);
            index++;
        }
        index = 0;
        String[] datas4 = in.nextLine().split(" +");
        for(String data: datas4){
            y2[index] = Integer.parseInt(data);
            index++;
        }
        int max = 0, rem = 0;
        for(int x: x1){
            for(int y: y1){
                rem = 0;
                for(int k=0;k<n;k++){
                    if((x >= x1[k] && y >= y1[k]) && (x < x2[k] && y < y2[k])){
                        rem++;
                    }
                }
                if(rem>max){
                    max = rem;
                }
            }
        }
        System.out.println(max);



    }
}
