package zhousai.doublecom.c23;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class C231 {

    /**
     * 题目的坑在于数字数目并列最多的组，要求组内的数字最多同时并列组数目最多
     * n<10^4，所以各个数位相加最多有27种情况，可以考虑桶排序思想
     * @param n
     * @return
     */
    public int countLargestGroup(int n) {
        // 首先使用桶排序思想，记录每个数为相加和出现多少次
        HashMap<Integer, Integer> result = new HashMap<>();
        int t,m;
        for(int i=1;i<=n;i++){
            t = 0;
            m = i;
            while (m>0){
                t += (m%10);
                m /= 10;
            }
            result.put(t, result.getOrDefault(t, 0)+1);
        }
        // 对于每组长度，再使用一次桶排序思想做统计
        HashMap<Integer, Integer> finalResult = new HashMap<>();
        for (Integer value : result.values()) {
            finalResult.put(value, finalResult.getOrDefault(value, 0)+1);
        }
        // 找出每组长度出现次数的最大值返回
        Collection<Integer> values = finalResult.keySet();
        Integer max = Collections.max(values);
        return finalResult.get(max);
    }

    public static void main(String[] args) {
        C231 c231 = new C231();
        System.out.println(c231.countLargestGroup(24));
    }

}
