package niuke.S2019;

import java.util.*;
public class Tqid32849{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        // 处理只有一行输入的情况
        if(!in.hasNext()){
            System.out.println(a);
            return ;
        }
        String b = in.nextLine();
        String[] dataa = a.split(",");
        String[] datab = b.split(",");
        int[] datas = new int[dataa.length+datab.length];
        int index1 = 0, index2 = 0;
        int index = 0;
        while(index1<dataa.length && index2<datab.length){
            if(Integer.parseInt(dataa[index1])<Integer.parseInt(datab[index2])){
                datas[index++] = Integer.parseInt(dataa[index1++]);
            }else{
                datas[index++] = Integer.parseInt(datab[index2++]);
            }
        }
        if(index1<dataa.length){
            while(index1<dataa.length){
                datas[index++] = Integer.parseInt(dataa[index1++]);
            }
        }else{
            while(index2<datab.length){
                datas[index++] = Integer.parseInt(datab[index2++]);
            }
        }
        System.out.print(datas[0]);
        for(int i=1;i<datas.length;i++){
            System.out.print(","+datas[i]);
        }




    }
}