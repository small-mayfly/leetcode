package niuke.S2019;

import java.util.*;

public class Tqid32827 {
    /**
     * 将四个方向顺时针遍历，写到数组中
     * 每次转向L为逆时针，R为顺时针
     * @param args
     */
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        char[] directs = {'N', 'E', 'S', 'W'};
        int num = Integer.valueOf(in.nextLine());
        String road = in.nextLine();
        int tresult = 0;
        for(int i=0;i<num;i++){
            char t = road.charAt(i);
            if(t=='L'){
                tresult = (tresult+3)%4;
            }else{
                tresult = (tresult+1)%4;
            }
        }

        System.out.println(directs[tresult]);

    }
}
