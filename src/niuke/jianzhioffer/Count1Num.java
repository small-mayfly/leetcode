package niuke.jianzhioffer;

public class Count1Num {

    public int NumberOf1Between1AndN_Solution(int n) {
        if (n == 0)   // n==0此时不存在1
            return 0;
        else if (n < 10)   // 0-9只有1个1
            return 1;

        int base;
        int upper;
        int lower;
        int count = 0;
        for(int i=1;i<10;i++){
            base = (int)(Math.pow(10, i));
            if(base>=n)
                break;
            upper = n/base;


            lower = n%base;

            if(upper%10==0){
                count += upper;
            }else if(upper%10==1){
                count += (upper+1);
                count += (lower);
            }else{

            }

            upper = upper/10-1;
            count += (upper+lower);
        }
        return count;
    }
    /**
     * 使用归纳法归纳出规律，然后将数字往规律上凑
     * 0-9 有1个1
     * 10-99 有1*10+10=20个1
     * 100-999 有20*10+100=300个1
     * 1000-9999 有300*10+1000=4000个1
     * 所以将数字进行拆分计算
     * @param n
     * @return
     */
    public int NumberOf1Between1AndN_Solution2(int n) {
        if(n==0)   // n==0此时不存在1
            return 0;
        else if(n<10)   // 0-9只有1个1
            return 1;
        // 首先判断n的位数
        int index = 9;
        for(int i=9;i>=0;i--){
            if(n>=Math.pow(10, index))
                break;
            index--;
        }
        // 计算出n的位数过后构造小于n的最大10^index数
        int base = (int)Math.pow(10, index);
        // 用于记录0-10^index共有多少个1
        int rem = (int)(index*Math.pow(10, index-1));
        // 因为数字开头为1的情况比较特殊，所以单拎出来计算
        if(n/base==1){
            if(n%base==0)   // 恰巧n==10^index则直接返回结果
                return 1+rem;
            else{
                // 否则将数字拆分为三部分，首先是0-10^index，然后是以1开头的数字的个数，最后是开头1之后的数字中1的个数
                return rem + (n+1-base) + NumberOf1Between1AndN_Solution(n-base);
            }
        }else{
            // 此时只要计算个数即可，思路同上
            int baseNum = base + (n/base)*rem;   // 首先计算出0-(10^index-1)中1的个数，然后计算10^index-n之间1的个数
            return baseNum + NumberOf1Between1AndN_Solution(n-(n/base)*base);
        }
    }

    public static void main(String[] args) {
        Count1Num cn = new Count1Num();
        System.out.println(cn.NumberOf1Between1AndN_Solution(55));
    }
}
