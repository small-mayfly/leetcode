package niuke.vivo2020;
// vivo2020届春季校园招聘在线编程考试

public class FirstOne {
    /**
     * 实现方案
     * @param m int整型 最少m个键
     * @param n int整型 最多n个键
     * @return int整型
     */
    public int solution (int m, int n) {
        int[] results = new int[10];
        results[0] = 0;

        int result = 0;
        if(n>2){
            int[] flags = new int[10];
            magic(m, n, 0, flags, results);
        }else{
            results[1] = 9;
            results[2] = 56;
        }
        for(int i=m;i<=n;i++){
            result += results[i];
        }



        return result;
    }

    public boolean judge(int[] flags, int id){
        if(id==5)
            return true;
        int i;
        if(id%2==1){
            i = 1;
            for(;i<10;i+=2){
                // 跳过本身和i==5的情况，i==5不可能与任何点相连跨过另外一个点
                if(i==id || i==5)
                    continue;
                // 奇数结点除了5结点以外，其它结点之间不能互相连接
                if(flags[i]==1 && flags[(i+id)/2]==0)
                    return false;
            }
        }else{
            i = 2;
            for(;i<10;i+=2){
                if(i==id)
                    continue;
                if(flags[i]==1)
                    if(i+id==10 && flags[5]==0)
                        return false;
            }
        }

        return true;
    }

    public void magic(int m, int n, int num, int[] flags, int[] results){
        if(num>=n){
            return;
        }
        for(int i=1;i<10;i++){
            if(flags[i]==0){
                flags[i] = 1;
                if(judge(flags, i)){
                    results[num+1]+=1;
                    magic(m,n,num+1,flags, results);
                }
                flags[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new FirstOne().solution(3, 3));
    }

}