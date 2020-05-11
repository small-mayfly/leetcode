package niuke.S2019;

import java.util.*;

public class Tqid32831 {
    /**
     * 动态规划的思想
     * @param args
     */
    public static void main(String[] args){


        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int w = in.nextInt();
        int[] vs = new int[n];
        for(int i=0;i<n;i++){
            vs[i] = in.nextInt();
        }
        // 将物品按照体积顺序排序
        Arrays.sort(vs);

        // 用以记录所有出现过的重量，减少内存消耗
        HashMap<Integer, Long> rems = new HashMap<Integer, Long>();
        // 总体积为0也算一种放法
        rems.put(0, 1L);
        // 依次尝试将每个物品放入
        for(int i=0;i<n;i++){
            // 获取当前已知的所有容量方法，计算新物品放入后的方法
            Integer[] tkeys = new Integer[rems.keySet().size()];
            rems.keySet().toArray(tkeys);
            // 从大的总体积开始向前计算
            for(int j=tkeys.length-1;j>=0;j--){
                int key = tkeys[j];
                if(key+vs[i]<=w && key+vs[i]>0)
                    rems.put(key+vs[i], rems.getOrDefault(key+vs[i], 0L)+rems.get(key));
            }
        }

        // 计算一共有多少种方法
        long sum = 0;
        Set<Integer> keys = rems.keySet();
        for(Integer key: keys){
            sum += rems.get(key);
        }
        System.out.println(sum);
    }
}
