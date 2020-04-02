package zhousai.doublecom.c20;

public class FourthClass {
    /**
     * 假设有n个快递，共有f(n)中摆放方法，如果有n+1个快递
     * 相当于把两个数字摆放在2n+2个空格中的任意两个，而其他2n个空中的数字共有f(n)中摆放方法，且这两个数字无序，则f(n+1)=C^2_2n*f(n)
     * @param n
     * @return
     */
    public int countOrders(int n) {
        // 已经知道结果，直接返回
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        if(n==2)
            return 6;
        if(n==3)
            return 90;
        //构造f(n)=C^2_2(n-1)*f(n)=2*(n-1) * 2 * n * f(n-1)
        long temp = 2 * n * (2 * n-1) / 2;
        temp *= countOrders(n-1);
        temp %= ((int)Math.pow(10, 9) + 7);
        return (int)temp;
    }

    public static void main(String[] args) {
        System.out.println(new FourthClass().countOrders(8));
    }
}
