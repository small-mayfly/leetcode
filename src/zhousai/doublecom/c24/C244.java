package zhousai.doublecom.c24;

import java.util.ArrayList;

/**
 * 动态规划问题
 * 首先将字符串切分为一个个的数字，如果是0则贴到上一个数字处，构造能够通过简单状态转移来解决
 * 大致思路，
 * f(n)表示计算node列表的前n个字符共能组成多少种情况
 * 计算第index数字时
 *  首先有f(index) = f(index-1)
 *  如果index、index-1两个节点中的值组合在一起仍然小于k，则f(index)+=f(index-2)
 *  注 节点列表node(index-1).data=2,node(index).data=3则组合在一起的值为23
 *  依次往前，直到所有数字组合在一起大于k或者遍历到第一个node结束
 * f(index) = f(index-1)+f(index-2)+...
 *
 */
public class C244 {
    class Node{
        int len;   // 用来记录这个值是多少位的
        long data;   // 记录值
    }

    public int numberOfArrays(String s, int k) {
        int countk = 0;   // 找出k由几位数字构成
        int t = k;
        while (t>0){
            countk++;
            t /= 10;
        }
        // 将字符串切分为一个个的node
        ArrayList<Node> nodes = new ArrayList<>();
        Node tnode = null;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!='0'){
                nodes.add(tnode);   // 第一个tnode为null，最后删除即可
                tnode = new Node();
                tnode.len = 1;
                tnode.data = s.charAt(i)-'0';
            }else {
                tnode.len++;
                tnode.data *= 10;
                if(tnode.data>Math.pow(10, 9))
                    return 0;
            }
        }
        nodes.add(tnode);
        nodes.remove(0);

        // 然后遍历是否存在一个数字一定大于k，如果存在则一定无解
        for (Node node : nodes) {
            if(node.len>countk && node.data>k){
                return 0;
            }
        }
        // 如果字符串不能切分，则直接返回结果
        if(nodes.size()==1){
            if(nodes.get(0).data<k){
                return 1;
            }else {
                return 0;
            }
        }

        // 设置备忘录，用于记录之前的状态
        // 状态转移思路为
        int[] rems = new int[nodes.size()+1];
        // 设置备忘录初始值
        rems[0] = 1;
        rems[1] = 1;
        // 从第二个节点开始向后依次计算
        for(int i=2;i<=nodes.size();i++){
            int nowLen = nodes.get(i-1).len;
            double nowData = nodes.get(i-1).data;
            rems[i] = rems[i-1];
            for(int j=i-2;j>=0;j--){
                int tLen = nodes.get(j).len;
                long tData = nodes.get(j).data;
                double ttt = tData*Math.pow(10, nowLen)+nowData;
                if(nowLen+tLen<=countk && ttt<=k){
                    rems[i] += (rems[j]);
                    rems[i] = rems[i] % ((int) Math.pow(10, 9) + 7);   // 按照题意取值对10^9 + 7 取余 后的结果
                    nowData = tData*Math.pow(10, nowLen)+nowData;
                    nowLen += tLen;
                }else{
                    break;
                }

            }
        }
        // 备忘录最后一个结果就是最终结果
        return rems[nodes.size()];
    }

    public static void main(String[] args) {
        C244 c244 = new C244();
        String s = "100000";
        int k = 1000;
        System.out.println(c244.numberOfArrays(s, k));
    }
}

