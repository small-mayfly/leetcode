package zhousai.doublecom.c22;

public class FirstTopic {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int rem = 0;
        boolean flag;
        for (int a : arr1) {
            flag = true;
            for (int b : arr2) {
                if(Math.abs(a-b)<=d){
                    flag = false;
                    break;
                }
            }
            if(flag)
                rem++;
        }

        return rem;
    }

    public static void main(String[] args) {
        int[] data1 = {2,1,100,3};
        int[] data2 = {-5,-2,10,-3,7};
        int d = 6;
        System.out.println(new FirstTopic().findTheDistanceValue(data1, data2, d));
    }
}
