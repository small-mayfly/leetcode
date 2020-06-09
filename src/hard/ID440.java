package hard;

public class ID440 {

    int result = -1;

    public int findKthNumber(int n, int k) {

        k--;
        int cur = 1;
        while(k>0){
            long step = 0, first = cur, last = cur+1;
            long tstep;
            // 统计树下所有结点数量
            while(last<n){
                tstep = Math.min(n+1, last)-first;
                step += tstep;
                first *= 10;
                last *= 10;
            }

            if(step<k){
                cur++;
                k -= step;
            }else if(step==k){   // 已经找到

            }else{   // 在子树中，进入子树
                cur *= 10;
                k--;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        ID440 id440 = new ID440();
        System.out.println(id440.findKthNumber(2,2));
    }
}
