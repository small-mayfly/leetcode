package niuke.jianzhioffer;

public class CountOverHalf {
    /**
     * 如果一个值在数组中出现次数超过数组长度的50%，
     * @param array
     * @return
     */
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array.length<1)   // 长度为0，直接返回
            return 0;
        else if(array.length==1)   // 长度为1，返回第一个值
            return array[0];
        else{
            int rem = array[0];
            int len = 1;
            for(int i=1;i<array.length;i++){
                if(array[i]==rem){
                    len++;
                }else{
                    len--;
                    if(len==0){
                        rem = array[i];
                        len = 1;
                    }
                }
            }
            len = 0;
            for(int i=0;i<array.length;i++){
                if(array[i]==rem){
                    len++;
                }
            }
            if(len>array.length/2){
                return rem;
            }else {
                return 0;
            }
        }
    }
}
