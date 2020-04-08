package niuke.jianzhioffer;

import java.util.*;

public class Tqid11217 {
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        if(num==null)
            return null;
        ArrayList<Integer> results = new ArrayList<>();
        if(size==0)
            return results;
        if(size>num.length){
            return results;

        }else{
            int rem = num[0];
            LinkedList<Integer> queue = new LinkedList<>();
            // 首先添加第一个最大值
            queue.addLast(rem);
            for(int i=1;i<size;i++){
                if(rem<num[i]){
                    rem = num[i];
                }
                queue.addLast(num[i]);
            }
            results.add(rem);

            for(int i=size;i<num.length;i++){

                Integer integer = queue.removeFirst();
                queue.addLast(num[i]);

                if(integer==rem || rem<num[i]){
                    rem = Collections.max(queue);
                }
                results.add(rem);

            }
        }

        return results;
    }

    public static void main(String[] args) {
        int[] datas = {2,3,4,2,6,2,5,1};
        int size = 3;
        Tqid11217 tqid11217 = new Tqid11217();
        ArrayList<Integer> integers = tqid11217.maxInWindows(datas, size);
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }
}
