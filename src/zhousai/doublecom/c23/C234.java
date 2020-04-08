package zhousai.doublecom.c23;

import java.util.Arrays;

public class C234 {

    /**
     * 首先对喜爱程度排序，然后取出所有喜爱程度非负的菜品，计算非负菜品的总喜爱程度以及只做非负菜品时的结果
     * 然后按照喜爱程度递减向前遍历，判断总喜爱程度是否能覆盖不喜欢成都，如果可以则可以做这个菜，因为这样结果会增加，否则不做这个菜
     * @param satisfaction
     * @return
     */
    public int maxSatisfaction(int[] satisfaction) {
        // 首先对喜爱程度排序，然后取出所有喜爱程度非负的菜品，计算非负菜品的总喜爱程度以及只做非负菜品时的结果
        Arrays.sort(satisfaction);
        int index = 0;
        for (index=0;index<satisfaction.length;index++){
            if(satisfaction[index]>=0)
                break;;
        }
        if(index==satisfaction.length){
            return 0;
        }
        int rem = 0;
        int result = 0;
        for(int i=index;i<satisfaction.length;i++){
            result += (satisfaction[i]*(i-index+1));
            rem += satisfaction[i];
        }
        // 之后开始遍历不喜爱菜品
        index--;
        while (index>=0){
            // 如果不喜爱菜品的不喜爱程度没有总的喜爱程度大，则可以做这道菜
            // 因为假设总喜爱程度为a，这道菜的不喜爱程度为-b，假设当前结果为r，则做这道菜品后总的结果为r+a-b>r所以可以做，否则则不做
            if(satisfaction[index]+rem>0){
                rem += satisfaction[index];
                result += rem;
            }else {   // 因为喜爱程度越往前，负值越大，所以前面没有必要再遍历
                break;
            }
            index--;

        }
        return result;
    }

    public static void main(String[] args) {
        C234 c234 = new C234();
        int[] satisfaction = {-2,5,-1,0,3,-3};
        System.out.println(c234.maxSatisfaction(satisfaction));
    }




}
