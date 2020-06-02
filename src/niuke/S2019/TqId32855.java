package niuke.S2019;

import java.util.*;

public class TqId32855{

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String oriStr = in.nextLine();
        String[] oriDatas = oriStr.split(",");
        int result = 0;
        if("".equals(oriStr)){
            result = 0;
        }else if(oriDatas.length==1){
            result = Integer.parseInt(oriDatas[0]);
            result = result>0?result:0;
        }else{
            ArrayList<Integer> datas = new ArrayList<>();
            int tempResult = 0;
            int t;
            // 首先将所有数字紧缩为正负正负这种形式
            for(int i=0;i<oriDatas.length;i++){
                t = Integer.parseInt(oriDatas[i]);
                if(tempResult==0){
                    tempResult += t;
                }else if(tempResult<0){
                    if(t<0){
                        tempResult += t;
                    }else{
                        datas.add(tempResult);
                        tempResult = t;
                    }
                }else{
                    if(t>0){
                        tempResult += t;
                    }else{
                        datas.add(tempResult);
                        tempResult = t;
                    }
                }
            }
            if(tempResult!=0){
                datas.add(tempResult);
                tempResult = 0;
            }
            // 循环遍历所有组合情况
            result = 0;
            for(int i=0;i<datas.size();i++){
                tempResult = 0;
                for(int j=i;j<datas.size();j++){
                    tempResult += datas.get(j);
                    if(tempResult>result){
                        result = tempResult;
                    }
                    // 如果前方序列和小于0，则可以直接抛弃
                    if(tempResult<0){
                        tempResult = 0;
                    }
                }
            }
            result = result>0?result:0;

        }
        System.out.println(result);
    }

}