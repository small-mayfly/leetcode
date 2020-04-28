package niuke.S2019;

import java.util.*;

public class Tqid32824 {


    public static void main(String[] args){
        // 设置记录变量
        int n,m;
        Map<Integer, Integer> salaries;
        LinkedList<Integer> ai;

        // 获取输入
        Scanner in = new Scanner(System.in);
        String data = in.nextLine();
        String[] datas = data.split(" ");
        n = Integer.parseInt(datas[0]);
        m = Integer.parseInt(datas[1]);
        salaries = new HashMap<Integer, Integer>();
        ai = new LinkedList<Integer>();
        for(int i=0;i<n;i++){
            data = in.nextLine();
            datas = data.split(" ");
            int hardNum = Integer.parseInt(datas[0]);
            int salary = Integer.parseInt(datas[1]);
            Integer oldSalary = salaries.getOrDefault(hardNum, 0);
            if(oldSalary<salary)
                salaries.put(hardNum, salary);
        }
        data = in.nextLine();
        datas = data.split(" ");
        for(int i=0;i<m;i++){
            int hardNum = Integer.parseInt(datas[i]);
            ai.addLast(hardNum);
            Integer oldSalary = salaries.getOrDefault(hardNum, -1);
            if(oldSalary==-1)
                salaries.put(hardNum, 0);
        }
        in.close();

        // 将难度从低到高排序
        int keySize = salaries.keySet().size();
        ArrayList<Integer> allHardNum = new ArrayList<>();
        for (Integer integer : salaries.keySet()) {
            allHardNum.add(integer);
        }
        for(int i=1;i<keySize;i++){
            if(salaries.get(allHardNum.get(i))<salaries.get(allHardNum.get(i-1))){
                salaries.put(allHardNum.get(i), salaries.get(allHardNum.get(i-1)));
            }
        }
        for (Integer nowNum : ai) {
            System.out.println(salaries.get(nowNum));
        }

    }


}
