package zhousai.weeklycom.c180;

import java.util.LinkedList;
import java.util.List;

public class TopicOne {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int height = matrix.length;
        if(height<1)
            return null;
        int width = matrix[0].length;
        int[] maxNums = new int[width];
        int[] maxNumsIndex = new int[width];   // 记录列最大值所在的行
        int[] minNums = new int[height];
        int[] minNumsIndex = new int[height];   // 记录行最小值所在的列

        for(int i=0;i<width;i++){
            int maxNum = matrix[0][i];
            for(int j=1;j<height;j++){
                if(maxNum<matrix[j][i]){
                    maxNum = matrix[j][i];
                    maxNumsIndex[i] = j;
                }
            }
            maxNums[i] = maxNum;
        }

        for(int i=0;i<height;i++){
            int minNum = matrix[i][0];
            for(int j=1;j<width;j++){
                if(minNum>matrix[i][j]){
                    minNum = matrix[i][j];
                    minNumsIndex[i] = j;
                }
            }
            minNums[i] = minNum;
        }

        LinkedList<Integer> results = new LinkedList<>();
        for(int i=0;i<height;i++){
            // data的坐标[i][minNumsIndex[i]]
            int data = minNums[i];

            if(maxNumsIndex[minNumsIndex[i]] == i){
                results.addLast(data);
            }
        }


        return results;
    }


    public static void main(String[] args) {
        TopicOne topicOne = new TopicOne();
        int[][] datas = {{1,10,4,2},{9,3,8,7},{15,16,17,12}};
        List<Integer> integers = topicOne.luckyNumbers(datas);
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }
}
