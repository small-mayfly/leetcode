package niuke.S2019;

import java.util.*;

public class TqId32853{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        String str = in.nextLine();
        StringBuilder sb = new StringBuilder();
        char rem = str.charAt(0);
        int len = 1;
        for(int i=1;i<str.length();i++){
            if(str.charAt(i)==rem){
                len++;
            }else{
                sb.append(len+""+rem);
                rem = str.charAt(i);
                len = 1;
            }
        }
        sb.append(len+""+rem);
        System.out.println(sb.toString());

    }
}