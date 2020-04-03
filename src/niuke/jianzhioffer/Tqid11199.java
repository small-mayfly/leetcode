package niuke.jianzhioffer;

public class Tqid11199 {
    public int LastRemaining_Solution(int n, int m) {


        if(n<1 || m<1)
            return -1;
        if(m==1)
            return n-1;

        int result = 0;
        for(int i=2;i<=n;i++){

            result = (result + m) % i;
        }
        return result;
    }



    public static void main(String[] args) {
        Tqid11199 tqid11199 = new Tqid11199();
        int n = 5;
        int m = 3;
        System.out.println(tqid11199.LastRemaining_Solution(n, m));
//        System.out.println(tqid11199.LastRemaining_Solution2(n, m));
    }
}
