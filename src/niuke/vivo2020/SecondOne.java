package niuke.vivo2020;

import java.io.*;

/**
 * Welcome to vivo !
 */

public class SecondOne {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = br.readLine();
        int input[] = parseInts(inputStr.split(" "));
        String output = solution(input);
        System.out.println(output);
    }

    private static int[] parseInts(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return new int[0];
        }
        int[] intArr = new int[strArr.length];
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = Integer.parseInt(strArr[i]);
        }
        return intArr;
    }

    private static int[] magic(int start, int m, int num, int[] datas){
        int[] results = new int[num];
        if(num==1){
            results[0] = datas[1];
        }else{
            start = start % num;
            int index = 0;
            int rem = 1;
            for(int i=start;i<num;i++){
                if(rem==1){
                    results[index++] = datas[i+1];
                    rem = m;
                }else{
                    rem--;
                    datas[i+1-((i+1)/3)] = datas[i+1];
                }
            }
            int[] tdatas = magic(rem-1, m, num-index, datas);
            int end = num - index;
            for(int i=0;i<end;i++){
                results[index++] = tdatas[i];
            }
        }
        return results;
    }

    private static String solution(int[] input) {

        int n = input[0];
        int m = input[1];
        int[] rems = new int[n+1];
        for(int i=0;i<n;i++)
            rems[i+1] = i+1;
        int[] datas;
        if(m>1){
            datas = magic(m-1, m, n, rems);
        }else{
            datas = rems;
        }

        StringBuffer sb = new StringBuffer();
        sb.append(datas[0]);
        for(int i=1;i<datas.length;i++){
            sb.append(" "+datas[i]);
        }

        return sb.toString();
    }

}