package niuke.S2019;

import java.util.Scanner;

public class Tqid32836 {
    /**
     * 一共只有6种情况，直接遍历即可
     * @param args
     */
    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        int result = a+b+c;
        int t = a*b*c;
        result = result<t?t:result;
        t = (a+b)*c;
        result = result<t?t:result;
        t = a*b+c;
        result = result<t?t:result;
        t = a+b*c;
        result = result<t?t:result;
        t = a*(b+c);
        result = result<t?t:result;
        System.out.println(result);

    }
}
