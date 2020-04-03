package niuke.jianzhioffer;

public class HouXuBianLiShu {

    public boolean magic(int[] seq, int start, int end){
        if(end==start)
            return true;

        // 记录中间值
        int medium = seq[end];
        // 找到左右子树的分界线
        int med = start;
        while(med<end){
            if(seq[med]<=medium)
                med++;
            else
                break;
        }
        if(seq[med]>=medium)
            med--;

        // 判断的开始不能小于start
        if(med<start)
            med = start;

        // 判断后方是否有比medium小的值，有就直接判false
        for (int i=med+1; i<end; i++){
            if(seq[i]<medium)
                return false;
        }

        if(med-start<=0){   // 左子树为空
            return magic(seq, start, end-1);
        }else if(end-med==1){   // 右子树为空
            return magic(seq, start, end-1);
        }else{   // 左右都不为空
            return magic(seq, start, med) & magic(seq, med+1, end-1);
        }
    }



    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length==0)
            return false;
        return magic(sequence, 0, sequence.length-1);
    }

    public static void main(String[] args) {
        int[] data = {4,8,6,12,16,14,10};
        System.out.println(new HouXuBianLiShu().VerifySquenceOfBST(data));
    }
}
