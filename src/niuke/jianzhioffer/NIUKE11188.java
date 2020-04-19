package niuke.jianzhioffer;

import java.util.Arrays;

/**
 * 题目
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 * 思路
 * 每次向前遍历，复杂度O(N^2)
 */
public class NIUKE11188 {
    /**
     * 思路
     *  每次向前遍历，复杂度O(N^2)
     * @param array
     * @return
     */
    public int InversePairs(int [] array) {
        if(array.length<2)
            return 0;
        int[] rems = new int[array.length];
        rems[0] = 0;
        int index = 0;
        int num1, num2;
        int temp;
        int result = 0;
        for(int i=1;i<array.length;i++){
            index = i-1;
            num1 = 0;
            num2 = 0;
            while (index>=0){
                temp = array[index] - array[i];
                if(temp==1){
                    num1 = rems[index] + 1;
                    break;
                }else if(temp>1){   // 当前数字比array[i]大，但无法参考
                    num2++;
                    if(num2>1000000007)
                        num2 %= 1000000007;
                }
                index--;
            }
            rems[i] = (num1 + num2) % 1000000007;
            result += rems[i];
            result %= 1000000007;
        }
        return result;
    }

    /**
     * [)
     * @param array
     * @param start
     * @param end
     * @return
     */
    public int magic(int[] array, int[] tarr, int start, int end){
        if(end-start==1)
            return 0;

        int mid = (end+start)/2;
        int result = 0;   // 用来记录当前部分的结果

        int left = magic(array, tarr, start, mid);
        int right = magic(array, tarr, mid, end);

        result += left;
        result += right;
        result %= 1000000007;


        // 进行一次归并排序，并计算二者合并序列时新增加的逆序对数个数
        int indexa = start;
        int indexb = mid;
        int tarrIndex = start;
        int leftLen = mid - start;   // 记录左半部分的长度
        while (indexa<mid && indexb<end){
            if(array[indexa]<array[indexb]){
                tarr[tarrIndex] = array[indexa];
                indexa++;
                leftLen--;
            }else{
                tarr[tarrIndex] = array[indexb];
                indexb++;
                result += leftLen;
                if(result>1000000007)
                    result %= 1000000007;
            }
            tarrIndex++;
        }
        if(indexa==mid){   // 右边没有用完
            while (indexb<end){
                tarr[tarrIndex++] = array[indexb++];
            }
        }else{   // 左边没有用完
            while (indexa<mid){
                tarr[tarrIndex++] = array[indexa++];
            }
        }
        // 将归并的结果拷会原数组
        System.arraycopy(tarr, start, array, start, end-start);
        return result%1000000007;
    }

    public int InversePairs2(int [] array){
        int arrLen = array.length;

        int[] temp = new int[arrLen];

        return magic(array, temp, 0, arrLen);
    }

    public static void main(String[] args) {
//        int[] datas = {364,637,341,406,747,995,234,971,571,219,993,407,416,366,315,301,601,650,418,355,460,505,360,965,516,648,727,667,465,849,455,181,486,149,588,233,144,174,557,67,746,550,474,162,268,142,463,221,882,576,604,739,288,569,256,936,275,401,497,82,935,983,583,523,697,478,147,795,380,973,958,115,773,870,259,655,446,863,735,784,3,671,433,630,425,930,64,266,235,187,284,665,874,80,45,848,38,811,267,575};
        int[] datas = {1,2,3,4,5,6,7,0};
        System.out.println(new NIUKE11188().InversePairs2(datas));
    }
}
