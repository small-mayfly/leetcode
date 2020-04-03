package niuke.jianzhioffer;

public class Tqid11200 {
    public int Sum_Solution(int n) {

        int result = n;
        boolean falg = (result>0) && ((result += Sum_Solution(n-1))>0);
        return result;

    }
}
