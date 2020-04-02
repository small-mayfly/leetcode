package zhousai.weeklycom.c180;

public class TopicFour {




    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int t;
        for(int i=0;i<efficiency.length;i++){
            for(int j=i+1;j<efficiency.length;j++){
                if(efficiency[i]<efficiency[j]){
                    t = efficiency[i];
                    efficiency[i] = efficiency[j];
                    efficiency[j] = t;
                    t = speed[i];
                    speed[i] = speed[j];
                    speed[j] = t;
                }
            }
        }

        int[] rem = new int[k];
        int nowRem;
        rem[0] = 0;
        int nowValue = speed[0];
        for(int i=1;i<k;i++){
            rem[i] = i;
            nowValue += speed[i];
            nowRem = i;
            while (nowRem>0 && speed[rem[nowRem]]<speed[rem[(nowRem+1)/2-1]]){
                t = rem[nowRem];
                rem[nowRem] = rem[(nowRem+1)/2-1];
                rem[(nowRem+1)/2-1] = t;
                nowRem = (nowRem+1)/2-1;
            }
        }


        int nowEfficiency = efficiency[k-1];

        for(int i=k;i<speed.length;i++){
            if(speed[i]>speed[rem[0]]){
                int nowSum = nowValue*nowEfficiency;
                int newSum = (nowValue-speed[rem[0]]+speed[i])*efficiency[i];
                if(newSum>nowSum){
                    nowValue = nowValue-speed[rem[0]]+speed[i];
                    nowValue %= 1000000007;
                    nowEfficiency = efficiency[i];
                    rem[0] = i;
                    nowRem = 0;
                    while (nowRem<k){
                        if((nowRem+1)*2-1<k && speed[rem[nowRem]]>speed[rem[(nowRem+1)*2-1]]){
                            t = rem[nowRem];
                            rem[nowRem] = rem[(nowRem+1)*2-1];
                            rem[(nowRem+1)*2-1] = t;
                            nowRem = (nowRem+1)*2-1;
                        }else if((nowRem+1)*2-1<k && speed[rem[nowRem]]>speed[rem[(nowRem+1)*2]]){
                            t = rem[nowRem];
                            rem[nowRem] = rem[(nowRem+1)*2];
                            rem[(nowRem+1)*2] = t;
                            nowRem = (nowRem+1)*2;
                        }else{
                            break;
                        }
                    }
                }


            }
        }
        return nowValue*nowEfficiency;
    }

    public static void main(String[] args) {
        int num = 6;
        int[] spped = {2,10,3,1,5,8};
        int[] efficiency = {5,4,3,9,7,2};
        int k = 4;
        System.out.println(new TopicFour().maxPerformance(num, spped, efficiency, k));
    }
}
