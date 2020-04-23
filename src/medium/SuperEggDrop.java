package medium;

public class SuperEggDrop {

    int[][] rems;

    public int magic(int k, int n){
        if(k==1){
            return n;
        }
        if(n==0)
            return 0;
        if(rems[k][n]>0){
            return rems[k][n];
        }else{
            int res = Integer.MAX_VALUE;
            for(int i=1;i<=n;i++){
                res = Math.min(res,
                        Math.max(
                                magic(k-1, i-1),   // 碎了
                                magic(k, n-i)   // 没碎
                        )+1);
            }
            return res;
        }
    }


    public int superEggDrop(int K, int N) {

        rems = new int[K+1][N+1];
        if(K==1){
            return N;
        }
        if(N==0)
            return 0;
        int res = Integer.MAX_VALUE;
        for(int i=1;i<=N;i++){
            res = Math.min(res,
                    Math.max(
                            magic(K-1, i-1),
                            magic(K, N-i)
                    )+1);
        }
        return res;
    }


    public static void main(String[] args) {
        SuperEggDrop superEggDrop = new SuperEggDrop();
        int k = 3;
        int n = 14;
        System.out.println(superEggDrop.superEggDrop(k, n));
    }

}
