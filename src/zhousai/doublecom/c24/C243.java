package zhousai.doublecom.c24;

public class C243 {
    /**
     * 其实就是全排列的变形
     * @param n
     * @param k
     * @return
     */
    public String getHappyString(int n, int k) {
        // 计算长度为n的字符串共有多少种排列
        long count = 3;
        for(int i=1;i<n;i++){
            count <<= 1;
        }
        // 如果k大于排列种类，则返回空
        if(count<k){
            return "";
        }

        char[] datas = {'a', 'b', 'c'};

        // 如果长度为1，则直接返回结果
        if(n==1){
            return ""+datas[k-1];
        }
        // 因为是从0开始计数，但是k是从1开始的，所以-1
        k--;
        // 存储结果字符串
        StringBuilder stringBuilder = new StringBuilder();
        // 添加第一个字符，因为第一个字符有三种情况
        int i1 = k / (1 << (n - 1));
        if(i1==0){
            stringBuilder.append('a');
        }else if(i1==1){
            stringBuilder.append('b');
            k -= (1 << (n - 1));
        }else{
            stringBuilder.append('c');
            k -= (2 << (n - 1));
        }

        // 之后通过将剩下的k转化为二进制数组来决定每一位选取的字母
        int[] culs = new int[n];

        for(int i=1;i<n-1;i++){
            culs[i] = k / (2<<(n-2-i));
            if(k>0)
                k = k % (2<<(n-2-i));
        }
        culs[n-1] = k;
        // 遍历设置每一个值
        int index = 0;
        boolean flag;
        char t;
        for(int i=1;i<n;i++){
            index = i-1;
            flag = (culs[i]==0);
            // 由上一个字符决定下一个字符的选择
            t = stringBuilder.charAt(index);
            if(t=='a'){
                if(flag){
                    stringBuilder.append('b');
                }else{
                    stringBuilder.append('c');
                }
            }else if(t=='b'){
                if(flag){
                    stringBuilder.append('a');
                }else{
                    stringBuilder.append('c');
                }
            }else{
                if(flag){
                    stringBuilder.append('a');
                }else{
                    stringBuilder.append('b');
                }
            }
        }
        // 返回字符串
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        C243 c243 = new C243();
        int n = 10;
        int k = 100;
        System.out.println(c243.getHappyString(n, k));
    }
}
