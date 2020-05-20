package niuke.S2019;

import java.util.Scanner;

public class Tqid32840 {
    /**
     * 因为是满二叉树，所以直接二分计算即可
     * @param datas
     * @param start
     * @param end
     * @return
     */
    public static int magic(int[] datas, int start, int end){
        if(start==end){
            int rem = datas[start];
            datas[start] = 0;
            return rem;
        }
        int mid = (start+end)/2;
        int left = magic(datas, start, mid-1);
        int right = magic(datas, mid+1, end);
        int result = left+right;
        left = datas[mid];
        datas[mid] = result;
        return left+result;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String[] zs = in.nextLine().split(" ");
        String[] qs = in.nextLine().split(" ");
        if(zs.length==0)
            return;
        int[] datas = new int[zs.length];
        for(int i=0;i<zs.length;i++){
            datas[i] = Integer.valueOf(qs[i]);
        }
        int mid = zs.length/2;
        int left = magic(datas, 0, mid-1);
        int right = magic(datas, mid+1, zs.length-1);
        datas[mid] = left+right;
        for(int i=0;i<zs.length-1;i++){
            System.out.print(datas[i]+" ");
        }
        System.out.println(datas[zs.length-1]);

    }
}
