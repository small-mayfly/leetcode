package zhousai.doublecom.c22;

import java.util.Arrays;

public class TwoTopic {

    public int judge(int[] datas){
        int rem = 0;
        if(datas[2]==0 && datas[3]==0 && datas[4]==0 && datas[5]==0){
            rem++;
            if(datas[6]==0 && datas[7]==0 && datas[8]==0 && datas[9]==0)
                rem++;
        }else if(datas[4]==0 && datas[5]==0 && datas[6]==0 && datas[7]==0){
            rem++;
        }else if(datas[6]==0 && datas[7]==0 && datas[8]==0 && datas[9]==0){
            rem++;
        }
        return rem;
    }

    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        // 首先将传入数据排序
        Arrays.sort(reservedSeats, (x, y)->x[0]-y[0]);
        int rem = 0;
        int index = 0;
        int initFlag;
        for(int i=1;i<=n;i++){
            // 如果这一行没有坐人则可以添加两组4人家庭
            if(index<reservedSeats.length && reservedSeats[index][0]>i){
                rem += 2;
            }else if(index>=reservedSeats.length){   // 说明此时还有没有遍历完的排数
                rem += 2;
            }else{
                initFlag = 15;
                while (index<reservedSeats.length && reservedSeats[index][0]==i){
                    if(initFlag==0){
                        index++;
                        continue;
                    }
                    int t = reservedSeats[index++][1];
                    if(t==1 || t==10)
                        continue;
                    t = 4 - t/2;
                    initFlag &= (15 - (1<<t));
                }
                if(initFlag==15){
                    rem += 2;
                }else if((initFlag&12)==12)
                    rem++;
                else if((initFlag&6)==6){
                    rem++;
                }else if((initFlag&3)==3){
                    rem++;
                }
            }
        }

        return rem;
    }

    public static void main(String[] args) {
        int n = 2;
        int[][] datas = {{1,6},{1,8},{1,3},{2,3},{1,10},{1,2},{1,5},{2,2},{2,4},{2,10},{1,7},{2,5}};
        System.out.println(new TwoTopic().maxNumberOfFamilies(n, datas));
    }
}
