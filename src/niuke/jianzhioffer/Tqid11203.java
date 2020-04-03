package niuke.jianzhioffer;

public class Tqid11203 {
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        int rem;
        for(int i=0;i<length;i++){
            rem = numbers[i];
            if(rem>=length){
                rem -= length;
            }
            if(numbers[rem]>length){
                duplication[0] = rem;
                return true;
            }else{
                numbers[rem] += length;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] datas = {2,1,3,0,4};
        int[] result = new int[3];
        Tqid11203 tqid11203 = new Tqid11203();
        System.out.println(tqid11203.duplicate(datas, 5, result));;
    }
}
