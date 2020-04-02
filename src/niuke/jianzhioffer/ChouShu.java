package niuke.jianzhioffer;

import java.util.ArrayList;

public class ChouShu {
    /**
     * 因为所有的丑数都是2，3，5的倍数，所以依次向后计数即可
     * 运行时间：62ms
     * 占用内存：10440k
     * @param index
     * @return
     */
    public int GetUglyNumber_Solution(int index) {
        // 小于7的所有数字都是丑数
        if(index<7)
            return index;
        else{
            // 用来记录所有记录着的丑数
            ArrayList<Integer> rems = new ArrayList<>(index);
            // 先将前6个丑数加入记录
            for(int i=1;i<7;i++)
                rems.add(i);
            // 从2开始向后遍历
            int nowIndex = 2;
            // 用于记录基础的倍数
            int[] base = {2,3,5};
            // 一些临时变量
            int temp;
            int newRem;
            int j;
            // 用以标注是否是当前得到的最大值
            boolean flag;
            while (nowIndex<=index){
                // 首先得到丑数
                temp = rems.get(nowIndex-1);
                // 从当前索引开始向后找，找到这个丑数合适的位置，这里因为a*5>a*3>a*2，所以每次循环j不需要都从nowIndex开始
                j = nowIndex;
                for (int i : base) {
                    newRem = temp*i;
                    flag = false;
                    for(;j<rems.size();j++){
                        if(newRem==rems.get(j)){   // 如果当前丑数已经在记录中则不需要插入
                            flag = true;
                            break;
                        }
                        else if(newRem<rems.get(j)){   // 找到合适的位置，插入
                            rems.add(j, newRem);
                            flag = true;
                            break;
                        }
                    }
                    if(!flag){   // 如果当前丑数大于已经记录的所有丑数就将当前丑数加入记录的末尾
                        rems.add(newRem);
                    }

                }
                nowIndex++;
            }
            // 记录中第index个数就是第index个丑数
            return rems.get(index-1);
        }

    }

    /**
     * 简化写法
     * 运行时间：28ms
     * 占用内存：9496k
     * @param index
     * @return
     */
    public int GetUglyNumber_Solution2(int index) {
        // 小于7的所有数字都是丑数
        if (index < 7)
            return index;
        else {
            // 用来记录所有记录着的丑数
            ArrayList<Integer> rems = new ArrayList<>(index);
            int r2=0;
            int r3=0;
            int r5=0;
            rems.add(1);
            int nowIndex = 1;
            int temp;
            while (nowIndex<=index){
                temp = Math.min(Math.min(rems.get(r2)*2, rems.get(r3)*3), rems.get(r5)*5);
                if(temp==rems.get(r2)*2)
                    r2++;
                if(temp==rems.get(r3)*3)
                    r3++;
                if(temp==rems.get(r5)*5)
                    r5++;
                rems.add(temp);

                nowIndex++;
            }
            return rems.get(index-1);
        }
    }

    /**
     * 所有的丑数都是以2，3，5为基数经过相互之间进行乘运算得到的，所以我们只要依次向后乘就能得到所有的结果。
     * 运行时间：22ms
     * 占用内存：9388k
     * @param index
     * @return
     */
    public int GetUglyNumber_Solution3(int index) {
        // 小于7的所有数字都是丑数
        if (index < 7)
            return index;
        else {
            int[] base = {2,3,5};   // 基础数字
            int[] remIndex = {0,0,0};   // 用于记录，每个基础数字当前的进度
            int[] compareData = {2,3,5};   // 表示对应于每个进度的数字大小
            int[] results = new int[index];
            results[0] = 1;
            int point=1;
            while (point<index){
                int minIndex = getMinIndex(compareData);
                if(results[point-1]<compareData[minIndex]){
                    results[point++] = compareData[minIndex];
                }
                remIndex[minIndex]++;
                compareData[minIndex] = results[remIndex[minIndex]] * base[minIndex];
            }


            return results[index-1];
        }
    }

    public int getMinIndex(int... datas){
        int len = datas.length;
        int minData = Integer.MAX_VALUE;
        int minIndex = -1;
        for(int i=0;i<datas.length;i++){
            if(datas[i]<minData){
                minData = datas[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static void main(String[] args) {
        System.out.println(new ChouShu().GetUglyNumber_Solution3(10));
    }
}
