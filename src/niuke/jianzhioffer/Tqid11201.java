package niuke.jianzhioffer;

public class Tqid11201 {
    /**
     * 主要考位运算，加法中进制的关系
     * @param num1
     * @param num2
     * @return
     */
    public int Add(int num1,int num2) {
        if(num1==0)
            return num2;
        if(num2==0)
            return num1;

        int t1, t2, t3;
        t1 = (num1 & num2)<<1;
        t2 = num1^num2;
        while (t1!=0){
            t3 = t1 ^ t2;
            t1 = (t1 & t2)<<1;
            t2 = t3;
        }


        return t2;

    }

    public static void main(String[] args) {
        Tqid11201 tqid11201 = new Tqid11201();
        int num1 = 2;
        int num2 = -1;
        System.out.println(tqid11201.Add(num1, num2));
    }
}
