package niuke.S2019;

import java.util.*;

public class Tqid32826 {
    /**
     * 贪心思想，每次尽可能向后移动
     * @param args
     */
    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.nextLine());
        for(int i=0;i<t;i++){
            int n = Integer.parseInt(in.nextLine());
            String s = in.nextLine();
            int count = 0;
            for(int j=0;j<n;j++){
                if(s.charAt(j)=='.'){
                    count++;
                    j+=2;
                }
            }
            System.out.println(count);
        }


    }
}
