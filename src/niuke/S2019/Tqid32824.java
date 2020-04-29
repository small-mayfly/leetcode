package niuke.S2019;

import java.util.*;

public class Tqid32824 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n,m;
        Integer[] ai;
        String[] nm = in.nextLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);

        ai = new Integer[m];

        HashMap<Integer, Integer> salaries = new HashMap<>();

        for(int i=0;i<n;i++){
            String[] datas = in.nextLine().split(" ");
            salaries.put(Integer.parseInt(datas[0]), Integer.parseInt(datas[1]));

        }
        String[] ais = in.nextLine().split(" ");
        for(int i=0;i<m;i++){
            ai[i] = Integer.parseInt(ais[i]);
            int oldSalary = salaries.getOrDefault(ai[i], -1);
            if(oldSalary==-1){
                salaries.put(ai[i], 0);
            }
        }
        Integer[] ks = new Integer[salaries.keySet().size()];
        int index = 0;
        for (Integer integer : salaries.keySet()) {
            ks[index] = integer;
            index++;
        }

        for(int i=1;i<ks.length;i++){
            if(salaries.get(ks[i])<salaries.get(ks[i-1])){
                salaries.put(ks[i], salaries.get(ks[i-1]));
            }
        }
        for(int i=0;i<ai.length;i++){
            System.out.println(salaries.get(ai[i]));
        }
    }


}
