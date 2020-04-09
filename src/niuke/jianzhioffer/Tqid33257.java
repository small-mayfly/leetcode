package niuke.jianzhioffer;

public class Tqid33257 {
    public int cutRope(int target) {
        int result = 0;
        for(int len=2;len<=target;len++){
            int tresult = 0;
            if(target%len==0){
                int base = target / len;
                tresult = 1;
                for(int i=0;i<len;i++){
                    tresult *= base;
                }
                if(tresult>result)
                    result = tresult;
            }else{
                int bigger = target % len;
                int base = target / len;
                tresult = 1;
                for(int i=0;i<bigger;i++){
                    tresult *= (base+1);
                }
                for(int i=bigger;i<len;i++){
                    tresult *= base;
                }
                if(tresult>result)
                    result = tresult;
            }

        }


        return result;
    }

    public static void main(String[] args) {
        Tqid33257 tqid33257 = new Tqid33257();
        System.out.println(tqid33257.cutRope(2));
    }
}
