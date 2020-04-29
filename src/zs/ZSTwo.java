package zs;

import java.util.Scanner;

public class ZSTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine())*2;
        String[] datas = scanner.nextLine().split(" ");
        int[] rems = new int[n];

        for(int i=0;i<n;i+=2){
            rems[i] = Integer.parseInt(datas[i]);
            rems[i+1] = Integer.parseInt(datas[i+1]);
        }
        int a,b,t,count=0;
        for (int i=0;i<n;i+=2){
            a = rems[i];
            b = a^1;
            if(b==rems[i+1]){
                continue;
            }
            count++;
            for(int j=i+2;j<n;j++){
                if(rems[j]==b){
                    t = rems[i+1];
                    rems[i+1] = rems[j];
                    rems[j] = t;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
